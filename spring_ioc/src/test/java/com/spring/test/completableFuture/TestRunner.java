package com.spring.test.completableFuture;

import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import static com.spring.test.utils.CommonUtils.sleep;
@SpringBootTest
@Log4j2
public class TestRunner {
    @Autowired
    private TestService testService;
    ExecutorService executor = Executors.newFixedThreadPool(4);

    @Test
    public void runAsyncAnd() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future2 = testService.getRes();
        System.out.println("waiting...");
        System.out.println(future2.get());
    }

    @Test
    public void runAsync() throws ExecutionException, InterruptedException {
        // 1. 在创建 CompletableFuture 时指定执行器
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("start get...");
            sleep(10000);
            return "Result from supplyAsync";
        }, executor);

        System.out.println("waiting...");
        System.out.println(future1.get());
    }

}
