package com.spring.test.utils;

import okhttp3.*;

import java.util.concurrent.TimeUnit;

public class OkHttpWebSocketClient {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url("ws://example.com/websocket")
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

        WebSocket webSocket = client.newWebSocket(request, listener);

        // Trigger shutdown of the dispatcher's executor so this process can exit cleanly.
        client.dispatcher().executorService().shutdown();
    }
}