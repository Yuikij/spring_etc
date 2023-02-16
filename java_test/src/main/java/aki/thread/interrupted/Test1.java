package aki.thread.interrupted;

import aki.thread.commonClass.utils.Utils;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    final static Object object = new Object();
    static ReentrantLock lock = new ReentrantLock();

    static Utils utils = new Utils();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            lock.lock();
            utils.log("lock");
            Utils.sleep(10000);
            lock.unlock();
            utils.log("unlock");
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
            lock.lock();
            utils.log("Thread2,获得锁");
            Utils.sleep(10000);
            utils.log("end sleep");
            lock.unlock();
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
        Utils.sleep(2000);
//        lock.lockInterruptibly();
//        System.out.println("interrupted");
        utils.log("thread.isInterrupted()", thread.isInterrupted());
        thread.interrupt();
        utils.log("thread.isInterrupted()", thread.isInterrupted());


    }
}
