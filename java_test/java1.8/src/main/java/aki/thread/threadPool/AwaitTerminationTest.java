package aki.thread.threadPool;

import aki.thread.commonClass.utils.Utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationTest {
    static IThreadPoolExecutor executor = new IThreadPoolExecutor(1,
            40, 10,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException {
        Runnable work = () -> Utils.sleep(1000);
        executor.execute(work);
        executor.shutdown();
        executor.awaitTermination(100,TimeUnit.DAYS);
        System.out.println(123);
    }
}
