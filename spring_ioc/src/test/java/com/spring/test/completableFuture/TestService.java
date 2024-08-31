package com.spring.test.completableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static com.spring.test.utils.CommonUtils.sleep;

@Service
public class TestService {

    @Async
    public CompletableFuture<String> getRes(){
        System.out.println("start get...");
        sleep(10000);
        return CompletableFuture.completedFuture("Result from getRes");
    }
}
