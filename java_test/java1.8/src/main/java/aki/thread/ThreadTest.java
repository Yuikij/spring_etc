package aki.thread;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;

public class ThreadTest {

    private  final static Object object = new Object();
    ExecutorService threadPool = Executors.newSingleThreadExecutor();


    static CountDownLatch countDownLatch = new CountDownLatch(5);
    public static void main(String[] args) throws InterruptedException {
       Thread thread1 =  new Thread(()->{
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("thread1");
           synchronized(object){
               System.out.println("notify");
               object.notify();
           }

        });
        thread1.start();
        thread1.join();
        System.out.println("join");
        synchronized(object){
            System.out.println("wait");
            object.wait();
        }

        System.out.println("main");




    }


}
