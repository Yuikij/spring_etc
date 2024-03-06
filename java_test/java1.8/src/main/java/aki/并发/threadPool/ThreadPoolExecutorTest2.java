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
            40, 1,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
    public static void main(String[] args) {
        Runnable runnable1 = ()->{
            ConcurrentUtils.sleep(100000);
            System.out.println("do run");
        };
        Runnable runnable = ()->{
            ConcurrentUtils.sleep(1000);
            System.out.println("do run");
        };

//        核心
        executor.execute(runnable1);
        ConcurrentUtils.sleep(1);
        ConcurrentUtils.printStatus("1",executor);
//        排队
        executor.execute(runnable);
        ConcurrentUtils.sleep(1);
        ConcurrentUtils.printStatus("2",executor);
//        最大
        executor.execute(runnable);
        ConcurrentUtils.sleep(1);
        ConcurrentUtils.printStatus("3",executor);
//        过1s
        ConcurrentUtils.sleep(1200);
        ConcurrentUtils.printStatus(" 过1s",executor);

        ConcurrentUtils.sleep(3000);
        ConcurrentUtils.printStatus("只有核心",executor);
    }

}
