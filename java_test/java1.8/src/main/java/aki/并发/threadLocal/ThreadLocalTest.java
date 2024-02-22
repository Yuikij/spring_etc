package aki.并发.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    private static final ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();//线程池
        ExecutorService executorService = Executors.newCachedThreadPool();//线程池
        executorService.execute(() -> {//1
            local.set(123);
            System.out.println(Thread.currentThread());
            System.out.println(Thread.currentThread().getName() + "==>" + local.get());
        });
        executorService.execute(() -> {//2
                    System.out.println(Thread.currentThread());
                    System.out.println(Thread.currentThread().getName() + "==>" + local.get());
                    local.remove();
                }
        );

        executorService.shutdown();

    }

}
