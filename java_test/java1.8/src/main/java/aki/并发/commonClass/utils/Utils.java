package aki.并发.commonClass.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

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

    /**
     * ------------------------------日志----------------------
     */

    public static void print(Object result) {
        System.out.printf("------%s------\n", result);
    }


    /**
     * ------------------------------线程----------------------
     */

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

    /**
     * ------------------------------反射----------------------
     */


    public static Object getPrivateField(Object object, String fieldName) {
        Class<?> cls = object.getClass();
        return getPrivateField(object, fieldName, cls);

    }

    public static Object getPrivateField(Object object, String fieldName, Class<?> cls) {
        try {
            if (cls.equals(Object.class)) {
                return null;
            }
            // 获取 fieldName字段
            Field nameField = cls.getDeclaredField(fieldName);
            // 设置字段可访问
            nameField.setAccessible(true);
            return nameField.get(object);
        } catch (Exception e) {
            return getPrivateField(object, fieldName, cls.getSuperclass());
        }
    }

    /**
     * ------------------------------线程池----------------------
     */

    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    /**
     * 获取线程池状态
     */
    public static String getThreadPoolState(ThreadPoolExecutor threadPoolExecutor) {
        String state = "null";
        try {
            AtomicInteger ctl = (AtomicInteger) getPrivateField(threadPoolExecutor, "ctl");
            Map<Integer, String> map = new HashMap<Integer, String>() {{
                put(RUNNING, "RUNNING");
                put(SHUTDOWN, "SHUTDOWN");
                put(STOP, "STOP");
                put(TIDYING, "TIDYING");
                put(TERMINATED, "TERMINATED");
            }};
            int rs = runStateOf(ctl.get());
            return map.get(rs);
        } catch (Exception e) {
            return state;
        }
    }

    public static void main(String[] args) {
        print("q", "r");
        print("q", "r");
    }
}
