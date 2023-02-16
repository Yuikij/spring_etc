package aki.thread.commonClass.utils;

public class Utils {

    boolean isLog = true;

    public Utils() {
    }

    public Utils(boolean isLog) {
        this.isLog = isLog;
    }

    public void log(String msg, Object result) {
        if (isLog) {
            print(msg, result);
        }
    }

    public void log(Object result) {
        if (isLog) {
            print(result);
        }
    }

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
        if (msg == null) {
            print(result);
        } else {
            System.out.printf("------%s : %s------\n", msg, result);
        }

    }

    public static void print(Object result) {
        System.out.printf("------%s------\n", result);
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

    public static void multiRun(int times, Runnable runnable) {
        for (int i = 0; i < times; i++) {
            new Thread(runnable).start();
        }
    }

    public static void main(String[] args) {
        print("q", "r");
        print("q", "r");
    }
}
