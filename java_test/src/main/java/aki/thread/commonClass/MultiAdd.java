package aki.thread.commonClass;

import java.util.concurrent.CountDownLatch;

public class MultiAdd<T> {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void doAdd(Runnable runnable) {
        try {
            new Thread(() -> {
                for (int i = 0; i < 50000; i++) {
                    runnable.run();
                }
                countDownLatch.countDown();
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 50000; i++) {
                    runnable.run();
                }
                countDownLatch.countDown();
            }).start();
            countDownLatch.await();
            countDownLatch = new CountDownLatch(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void doAdd(Addable addable) {
        try {
            new Thread(() -> {
                for (int i = 0; i < 50000; i++) {
                    addable.add(i);
                }
                countDownLatch.countDown();
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 50000; i++) {
                    addable.add(i);
                }
                countDownLatch.countDown();
            }).start();
            countDownLatch.await();
            countDownLatch = new CountDownLatch(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
