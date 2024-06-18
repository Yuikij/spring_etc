package com.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

@SpringBootTest
class TestApplicationTests {


    @Resource(name = "threadPool")
    private Executor threadPool;

    @Test
    void testStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println(stopWatch);
    }

    @Test
    void contextLoads() {

        threadPool.execute(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(22);
        });

        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("开始执行任务，计划返回：123");
            return "123";
        });
        threadPool.execute(task);
        task.cancel(true);


//        new Thread(()->{
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(22);
//        }).start();

        System.out.println(11);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
