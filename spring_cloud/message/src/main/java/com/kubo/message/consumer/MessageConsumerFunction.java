package com.kubo.message.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MessageConsumerFunction {
    @Bean
    public Consumer<String> log2() {
        return response -> {
            System.out.println("Received: " + response);
        };
    }
}
