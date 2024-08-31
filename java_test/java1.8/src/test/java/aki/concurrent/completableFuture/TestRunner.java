package aki.concurrent.completableFuture;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static aki.demo.util.ToolUtils.sleep;

public class TestRunner {
    ExecutorService executor = Executors.newFixedThreadPool(4);

    @Test
    public void run() throws ExecutionException, InterruptedException {
        // 1. 在创建 CompletableFuture 时指定执行器
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
//            sleep(10000);
//            return "Result from supplyAsync";
//        }, executor);
//

        CompletableFuture<String> future2 = getRes();
        System.out.println("waiting...");
        System.out.println(future2.get());
    }
    @Async
    public CompletableFuture<String> getRes(){
        System.out.println("start get...");
        sleep(10000);
        return CompletableFuture.completedFuture("Result from getRes");
    }
}
