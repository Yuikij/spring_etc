package aki.thread.threadPool;

import aki.thread.commonClass.utils.Utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class CompletableFutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool.commonPool();

        CompletableFuture<String> future = CompletableFuture.completedFuture("123");

        CompletableFuture<String> stringCompletableFuture = future.thenApplyAsync(str -> {
            Utils.print("thenApply:", str);
            Utils.sleep(1000);
            return "thenApply";
        });
//        System.out.println(12311);
        stringCompletableFuture.complete("13344");
        System.out.println(stringCompletableFuture.get());

//        CompletableFuture<String> thenApplyAsync = thenApply.thenApplyAsync(str -> {
//            Utils.print("thenApplyAsync:", str);
//            Utils.sleep(1000);
//            return "thenApplyAsync";
//        });
//
//        CompletableFuture<String> thenApply2 = thenApplyAsync.thenApply(str -> {
//            Utils.print("thenApply2:", str);
//            Utils.sleep(1000);
//            return "thenApply2";
//        });
//
//
//
//        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "");
//
//        Utils.print("main:",thenApply2.get());
    }
}
