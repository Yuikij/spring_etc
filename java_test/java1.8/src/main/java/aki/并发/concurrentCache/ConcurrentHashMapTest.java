package aki.并发.concurrentCache;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {

        test();
//        int n = 16;
//
//        System.out.println(  Runtime.getRuntime().availableProcessors());
//        for (int i = 0; i <10 ; i++) {
//            new Thread(()->{
//                System.out.println(Thread.currentThread());
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        ThreadLocalRandom.getProbe();
    }

    static void  test(){
        int n = 400;
        System.out.println(n >>> 3);
        System.out.println(NCPU);
        System.out.println((NCPU > 1) ? (n >>> 3) / NCPU : n);
    }
}
