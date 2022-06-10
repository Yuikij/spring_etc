package aki.thread.interrupted;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    final static Object object = new Object();
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            lock.lock();
            System.out.println("Thread1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }).start();


        Thread thread = new Thread(() -> {
            System.out.println("Thread2");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Thread.currentThread().interrupt();
//            中断不抛出异常
//            LockSupport.park();
//            Thread.interrupted();
            System.out.println("Thread2,获得锁");
            try {
                Thread.sleep(10000);
                System.out.println("end sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            try {
//                synchronized (object){
//                    object.wait(10000);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        });
//

        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        lock.lockInterruptibly();
//        System.out.println("interrupted");
        System.out.println(thread.isInterrupted());
        ;
        thread.interrupt();

        System.out.println(thread.isInterrupted());



    }
}
