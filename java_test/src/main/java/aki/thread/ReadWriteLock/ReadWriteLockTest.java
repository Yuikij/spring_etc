package aki.thread.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {

            readWriteLock.readLock().lock();
            readWriteLock.writeLock().lock();
            readWriteLock.writeLock().unlock();
            System.out.println("读...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readWriteLock.readLock().unlock();
        }).start();
        Thread.sleep(200);
        readWriteLock.writeLock().lock();
        System.out.println("写...");
    }

}
