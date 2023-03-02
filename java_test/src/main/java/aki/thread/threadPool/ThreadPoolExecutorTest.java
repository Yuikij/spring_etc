package aki.thread.threadPool;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 自定义线程池的相关测试
 */
public class ThreadPoolExecutorTest {
    /*
     * corePoolSize: 核心线程数,核心线程数一旦创建就不销毁
     *
     * maximumPoolSize: 最大线程数，在corePooSize已满、队列也满的情况下，扩充线程至此值
     *
     * keepAliveTime:当线程数大于核心数时，这是多余的空闲线程在终止前等待新任务的最长时间。
     *
     * unit: 时间单位
     *
     * BlockingQueue<Runnable> workQueue: 阻塞队列
     *      - LinkedBlockingQueue
     *      - LinkedBlockingDeque
     *      - SynchronousQueue
     *      - DelayedWorkQueue
     *
     * RejectedExecutionHandler handler: 拒绝策略,核心数和队列满的时候触发
     *      - DiscardOldestPolicy: 丢弃最旧的策略，即丢弃队列头部任务，重试execute
     *      - CallerRunsPolicy:占用调用线程直接运行
     *      - DiscardPolicy
     *      - AbortPolicy
     *
     * ThreadFactory threadFactory:
     *      - DefaultThreadFactory
     *      - PrivilegedThreadFactory
     *
     *
     * todo
     *  - 核心线程是直接创建好的吗? 不是
     * */

    public static Instant start;

    static ThreadPoolExecutor executor = new IThreadPoolExecutor(10,
            40, 10,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
//            Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    static List<Integer> executedNums = new ArrayList<>();

    static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) {
        start = Instant.now();
        printStatus("start main");
        workLoop();
        System.out.println("--end main--");
    }


    private static void work(int n) {
        System.out.println("-------start work" + n + "--------");
        executedNums.add(n);

/*      用来测试keepAliveTime

        keepAliveTime 设为10s core:10 queue：1 maxSize：n > 1

        n=10 先排队 -》 n=2 + n=10 共花费20s ，此后空闲10s

        因此 在30s后 ，线程池大小从11变成10

        sleep((n == 2 || n == 10) ? 10000 : 50000);

*/

        sleep(10000);
        System.out.println("--end work" + n + "--");
    }


    private static void workLoop() {

        //添加100次任务
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            System.out.println("-------put work" + i + "--------");
            printStatus();
            executor.execute(() -> work(finalI));
        }


        //打印后续状态
        while (true) {
            sleep(1000);
            printStatus();
        }

    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printStatus() {
        printStatus("");
    }

    private static void printStatus(String msg) {
        System.out.println("-------------------线程池状态:" + msg + "-------------------");
        System.out.printf("time:%d%n", Duration.between(start, Instant.now()).toMillis());
        System.out.printf("线程池大小:%d%n", executor.getPoolSize());
        System.out.printf("核心线程池大小:%d%n", executor.getCorePoolSize());
        System.out.printf("正在执行数量:%d%n", executor.getActiveCount());
        System.out.printf("池中曾经同时存在的最大线程数:%d%n", executor.getLargestPoolSize());
        System.out.printf("队列中的数量:%d%n", executor.getQueue().size());
        System.out.println("----------------------------------------------");
    }

    private static List<Integer> getFullNums() {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            res.add(i);
        }
        return res;
    }

}
