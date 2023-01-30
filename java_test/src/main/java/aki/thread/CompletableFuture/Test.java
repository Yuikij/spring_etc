package aki.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class Test {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        future.thenApply(s -> s + " World").thenAccept(System.out::println).join();
//        System.out.println(future.thenApply(s -> s + " World").get());
    }
}
