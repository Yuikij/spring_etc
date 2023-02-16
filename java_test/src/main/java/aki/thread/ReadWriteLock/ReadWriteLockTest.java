package aki.thread.ReadWriteLock;

import aki.thread.commonClass.utils.Utils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {

        Utils utils = new Utils();

        Utils.multiRun(1,()->{
            readWriteLock.readLock().lock();
            utils.log("start read",Thread.currentThread().getId());
            Utils.sleep(8000);
            utils.log("end read",Thread.currentThread().getId());
            readWriteLock.readLock().unlock();
        });
        Utils.multiRun(1,()->{
            readWriteLock.readLock().lock();
            utils.log("start read",Thread.currentThread().getId());
            Utils.sleep(6000);
            utils.log("end read",Thread.currentThread().getId());
            readWriteLock.readLock().unlock();
        });
        Utils.multiRun(1,()->{
            readWriteLock.writeLock().lock();
            utils.log("start write",Thread.currentThread().getId());
            Utils.sleep(6000);
            utils.log("end write",Thread.currentThread().getId());
            readWriteLock.writeLock().unlock();
        });
        Utils.multiRun(1,()->{
            readWriteLock.readLock().lock();
            utils.log("start read",Thread.currentThread().getId());
            Utils.sleep(6000);
            utils.log("end read",Thread.currentThread().getId());
            readWriteLock.readLock().unlock();
        });
        Utils.multiRun(1,()->{
            readWriteLock.writeLock().lock();
            utils.log("start write",Thread.currentThread().getId());
            Utils.sleep(6000);
            utils.log("end write",Thread.currentThread().getId());
            readWriteLock.writeLock().unlock();
        });
    }

}
