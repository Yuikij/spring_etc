package aki.并发.threadPool;

import aki.common.utiles.ConcurrentUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 自定义线程池的相关测试
 */
public class ThreadPoolExecutorTest2 {
    static ThreadPoolExecutor executor = new IThreadPoolExecutor(1,
            40, 10,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
    public static void main(String[] args) {
        Runnable runnable = ()->{
            ConcurrentUtils.sleep(100000);
            System.out.println("do run");
        };

        executor.execute(runnable);
        ConcurrentUtils.sleep(1);
        ConcurrentUtils.printStatus("1",executor);
        executor.execute(runnable);
        ConcurrentUtils.sleep(1);
        ConcurrentUtils.printStatus("2",executor);
        executor.execute(runnable);
        ConcurrentUtils.sleep(1);
        ConcurrentUtils.printStatus("3",executor);

    }

}
