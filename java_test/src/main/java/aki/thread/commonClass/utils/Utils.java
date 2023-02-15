package aki.thread.commonClass.utils;

public class Utils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millis, Runnable runnable) {
        try {
            new Thread(() -> {
                sleep(millis / 2);
                runnable.run();
            }).start();
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print(String msg, Object result) {
        System.out.printf("------%s : %s------\n", msg, result);
    }

    public static void block(Object o, Runnable runnable) {
        new Thread(() -> {
            synchronized (o) {
                sleep(1000);
                runnable.run();
                sleep(1000);
            }
        }).start();
    }

    public static void iWait(Object o, Runnable runnable) {
        try {
            new Thread(() -> {
                sleep(1000);
                runnable.run();
                synchronized (o) {
                    o.notify();
                }
            }).start();
            o.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void iWait(Object o) {
        try {
            o.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        print("q", "r");
        print("q", "r");
    }
}
