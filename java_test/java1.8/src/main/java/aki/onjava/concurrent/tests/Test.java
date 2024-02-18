package aki.onjava.concurrent.tests;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture<T> static:
 * - supplyAsync: 异步立刻执行
 * - completedFuture: 不执行任务，直接返回 T
 *
 * - thenApplyAsync: 在当前线程中异步处理上个任务，并返回结果
 * - thenApply: 同步
 * - thenAccept: 执行完成后，接收返回结果，不返回
 *  - 上个任务抛出异常就不执行下一个then*
 * - get:　阻塞获取异步结果
 *
 * - complete(T):  主动完成
 * - completeExceptionally: 主动抛出异常
 *
 * - exceptionally((ex) -> ()): thenApplyAsync等如果异常了会进入
 * - handle((result, fail) -> ()): 都会进入
 * - whenComplete: 没有返回值
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            // 在另一个线程中执行耗时任务
//            sleep(1000);
//            return "Hello CompletableFuture";
//        });
        CompletableFuture<String> future = CompletableFuture.completedFuture("Hello CompletableFuture:1");
        future.thenApply(str -> {
                    System.out.println(str);
                    sleep(1000);
                    return "Hello CompletableFuture:2";
                });
        System.out.println("after thenApply");
        CompletableFuture<Void> voidCompletableFuture = future.thenApplyAsync(str -> {
            System.out.println(str);
            sleep(1000);
            return "Hello CompletableFuture:3";
        }).thenAccept(result -> System.out.println(result));

        System.out.println("after thenApplyAsync");

        voidCompletableFuture.get();

        new Thread(() -> {
            System.out.println("start do something");
            sleep(5 * 1000);
            System.out.println("end do something");
        }).start();
    }


    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
