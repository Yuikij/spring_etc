package aki.并发.threadPool;

import java.util.concurrent.*;

public class OtherPoolTest {
    public static void main(String[] args) {
//(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        Executors.newCachedThreadPool();


//(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        Executors.newFixedThreadPool(1);

//(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new ScheduledThreadPoolExecutor.DelayedWorkQueue());
        Executors.newScheduledThreadPool(1);


//(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())
        Executors.newSingleThreadExecutor();

//???
        Executors.newWorkStealingPool();


    }
}
