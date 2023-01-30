package aki.thread.线程安全容器;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ConcurrentHashMapTest {
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        int n = 16;

        System.out.println(  Runtime.getRuntime().availableProcessors());
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
//        ThreadLocalRandom.getProbe();
    }
}
