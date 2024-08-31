package aki.guava;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;

public class ListenableFutureT {
    public static void main(String[] args) {
        // 创建一个 ListeningExecutorService
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Integer> future1 = service.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });


    }
}
