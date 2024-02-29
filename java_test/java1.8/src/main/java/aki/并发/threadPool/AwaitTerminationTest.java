package aki.并发.threadPool;

import aki.并发.commonClass.utils.Utils;

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
        Runnable work = () -> Utils.sleep(10000,()->{
            System.out.println("等待10s");
        });
        executor.execute(work);
        executor.shutdown();
        // 最多等待（阻塞） timeout 时间，返回结果：线程池有没有达到最终状态 TERMINATED
        executor.awaitTermination(1,TimeUnit.SECONDS);
        System.out.println("end");
    }
}
