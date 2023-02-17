package aki.thread.ThreadPool;

import aki.thread.commonClass.utils.Utils;

import java.util.concurrent.*;

public class Lifecycle {
    static Utils utils = new Utils();

    static IThreadPoolExecutor executor = new IThreadPoolExecutor(10,
            40, 10,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException {
        executor.setRunnable(()->{
            utils.log("执行terminated", Utils.getThreadPoolState(executor));
        });

        Runnable work = () -> Utils.sleep(1000);
        utils.log("初始状态", Utils.getThreadPoolState(executor));
        executor.execute(work);

        executor.shutdown();
        utils.log("调用shutdown", Utils.getThreadPoolState(executor));

        executor.shutdownNow();
        utils.log("调用shutdownNow", Utils.getThreadPoolState(executor));

        Utils.sleep(1000);
        utils.log("结束", Utils.getThreadPoolState(executor));

    }
}