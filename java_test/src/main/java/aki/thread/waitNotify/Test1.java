package aki.thread.waitNotify;

import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(() -> {

            synchronized (obj) {
                try {
                    System.out.println("wait");
                    obj.wait();
                    System.out.println("end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {

            synchronized (obj) {
                System.out.println("synchronized");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (obj) {
                System.out.println("notify");
                obj.notify();
            }
        }).start();
    }
}
