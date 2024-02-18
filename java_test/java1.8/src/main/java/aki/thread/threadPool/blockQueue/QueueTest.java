package aki.thread.threadPool.blockQueue;

import java.util.concurrent.*;

public class QueueTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test3();
    }

    public static void test4() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            Thread.sleep(2000);
            return 1;
        });
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println( futureTask.get());
    }

    public static void test3() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 100000, TimeUnit.DAYS, new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());
        Future<Integer> future = threadPoolExecutor.submit(()->{
            Thread.sleep(2000);
            return 1;
        });
        System.out.println( future.get());
    }

    private static void test1() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 100000, TimeUnit.DAYS, new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
            });
//            threadPoolExecutor.submit()
        }
        System.out.println("activeCount:"+Thread.activeCount());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("activeCount2:"+Thread.activeCount());
    }

    private static void test2() throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);
        new Thread(()->{
            try {
                Thread.sleep(2000);
                arrayBlockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        arrayBlockingQueue.put(5);

    }
}
