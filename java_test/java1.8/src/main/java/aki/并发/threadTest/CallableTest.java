package aki.并发.threadTest;

import aki.common.utiles.ConcurrentUtils;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 有返回值的run
        Callable<Integer> callable = () -> {
            ConcurrentUtils.sleep(1000);
            return 1;
        };
        // 线程池的submit
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<Integer> submit = executorService.submit(callable);
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
//        FutureTask
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer i = futureTask.get();
        System.out.println(i);
    }
}
