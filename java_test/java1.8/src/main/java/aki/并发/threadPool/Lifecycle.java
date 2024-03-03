package aki.并发.threadPool;

import aki.common.utiles.ConcurrentUtils;

import java.util.concurrent.*;

public class Lifecycle {
    static ConcurrentUtils utils = new ConcurrentUtils();

    static IThreadPoolExecutor executor = new IThreadPoolExecutor(10,
            40, 10,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException {
        executor.setRunnable(()->{
            utils.log("执行terminated", ConcurrentUtils.getThreadPoolState(executor));
        });

        Runnable work = () -> ConcurrentUtils.sleep(1000);
        utils.log("初始状态", ConcurrentUtils.getThreadPoolState(executor));
        executor.execute(work);

        executor.shutdown();
        utils.log("调用shutdown", ConcurrentUtils.getThreadPoolState(executor));

        executor.shutdownNow();
        utils.log("调用shutdownNow", ConcurrentUtils.getThreadPoolState(executor));

        ConcurrentUtils.sleep(1000);
        utils.log("结束", ConcurrentUtils.getThreadPoolState(executor));

    }
}