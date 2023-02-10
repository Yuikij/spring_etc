package com.kubo.message;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@SpringBootApplication
@RestController
public class MessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

    @GetMapping("/qqq")
    public void test(){

    }

    @Bean
    public Function<String, String> toUpperCase() {
        return String::toUpperCase;
    }

    @Bean
    public Consumer<Person> log() {
        return person -> {
            System.out.println("Received: " + person);
        };
    }

    @Bean
    public Consumer<String> log2() {
        return response -> {
            System.out.println("Received: " + response);
        };
    }

    public static class Person {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String toString() {
            return this.name;
        }
    }

}
