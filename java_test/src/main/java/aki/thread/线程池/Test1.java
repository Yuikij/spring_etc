package aki.thread.线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test1 {
    /*
     *
     * keepAliveTime:当线程数大于核心数时，这是多余的空闲线程在终止前等待新任务的最长时间。
     *
     *
     * RejectedExecutionHandler: 核心数和队列满的时候触发
     *      DiscardOldestPolicy: 丢弃最旧的策略，即丢弃队列头部任务，重试execute
     *      CallerRunsPolicy:占用调用线程直接运行
     *
     *
     * todo keepAliveTime
     * */
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
            40, 1000,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(30),
//            Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    static List<Integer> executedNums = new ArrayList<>();

    static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) {
        System.out.println("--start main--");
        printStatus();
        sleep(5000);
        printStatus();
        work1Loop();
        System.out.println("--end main--");
    }

    private static void work(int n) {
        System.out.println("-------start work" + n + "--------");
        executedNums.add(n);
        sleep(10000);
        System.out.println("--end work" + n + "--");
    }

    private static void work1Loop() {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            System.out.println("-------put work" + i + "--------");
            printStatus();
            executor.execute(() -> work(finalI));
        }

        while (true) {
            sleep(1000);
            System.out.println("--------执行完毕---------");
            printStatus();

        }
//        System.out.println("--------执行完毕---------");
//        System.out.println(executedNums);
//        List<Integer> fullNums = getFullNums();
//        fullNums.removeAll(executedNums);
//        System.out.println(executedNums);
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printStatus() {
        System.out.println("-------------------线程池状态-------------------");
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
