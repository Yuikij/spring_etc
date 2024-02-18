package aki.onjava.concurrent.tests;

import aki.onjava.concurrent.Breakable;

import java.util.concurrent.CompletableFuture;

public class Test2 {
    public static void main(String[] args) {

        CompletableFuture.completedFuture(new Breakable("1", 1))
                .thenApply(Breakable::work).thenApplyAsync(r -> {
                            System.out.println("result: " + r);
                            return r;
                        }
                );
    }
}
