package com.spring.test;


import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Log4j2
public class WebSocketTest {
    public static ExecutorService executor = Executors.newCachedThreadPool();
    static  int count = 5000;
    public static CountDownLatch countDownLatch = new CountDownLatch(count+1);
    @Test
    void testStopWatch() throws InterruptedException {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url("ws://192.168.9.148/enbo-message/websocket?588fbdc1-804f-4797-9c52-231c2c85e4e8")
                .build();

        WebSocketListener listener = new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                System.out.println("Connected to server");
                webSocket.send("Hello, server!");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                System.out.println("Received message: " + text);
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                webSocket.close(1000, null);
                System.out.println("Connection closed: " + reason);
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                t.printStackTrace();
            }
        };

        Runnable runnable= ()->{
            try {
                WebSocket webSocket = client.newWebSocket(request, listener);
                log.info("-------------测试---------------");
            } catch (Exception e) {
                System.err.println("Exception in thread: " + Thread.currentThread().getName() + " - " + e.getMessage());
            } finally {
                countDownLatch.countDown(); // 确保无论任务是否成功都调用 countDown
            }

        };
        for (int i = 0; i < count; i++) {
            executor.submit(runnable);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("-------------测试完成---------------");
    }
}