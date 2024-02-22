package aki.并发.ReenTrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException{

        new Thread(()->{
            reentrantLock.lock();
            System.out.println("Thread1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }).start();


        for (int i = 2; i <10 ; i++) {
            Thread.sleep(1000);
            int finalI = i;
            new Thread(()->{
                reentrantLock.lock();
                System.out.println("Thread"+ finalI);
                reentrantLock.unlock();
            }).start();
        }

//        Thread.sleep(1000);
//        new Thread(()->{
//            reentrantLock.lock();
//            System.out.println("Thread2");
//            reentrantLock.unlock();
//        }).start();
//        Thread.sleep(1000);
//        new Thread(()->{
//            reentrantLock.lock();
//            System.out.println("Thread3");
//            reentrantLock.unlock();
//        }).start();
    }
}
