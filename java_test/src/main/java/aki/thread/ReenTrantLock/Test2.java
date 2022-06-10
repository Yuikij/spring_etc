package aki.thread.ReenTrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args){



        new Thread(() -> {
            reentrantLock.lock();
            System.out.println("Thread1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("Thread2");
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }).start();


    }
}
