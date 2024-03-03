package aki.并发.ReadWriteLock;

import aki.common.utiles.ConcurrentUtils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {

        ConcurrentUtils utils = new ConcurrentUtils();

        ConcurrentUtils.multiRun(1,()->{
            readWriteLock.readLock().lock();
            utils.log("start read",Thread.currentThread().getId());
            ConcurrentUtils.sleep(8000);
            utils.log("end read",Thread.currentThread().getId());
            readWriteLock.readLock().unlock();
        });
        ConcurrentUtils.multiRun(1,()->{
            readWriteLock.readLock().lock();
            utils.log("start read",Thread.currentThread().getId());
            ConcurrentUtils.sleep(6000);
            utils.log("end read",Thread.currentThread().getId());
            readWriteLock.readLock().unlock();
        });
        ConcurrentUtils.multiRun(1,()->{
            readWriteLock.writeLock().lock();
            utils.log("start write",Thread.currentThread().getId());
            ConcurrentUtils.sleep(6000);
            utils.log("end write",Thread.currentThread().getId());
            readWriteLock.writeLock().unlock();
        });
        ConcurrentUtils.multiRun(1,()->{
            readWriteLock.readLock().lock();
            utils.log("start read",Thread.currentThread().getId());
            ConcurrentUtils.sleep(6000);
            utils.log("end read",Thread.currentThread().getId());
            readWriteLock.readLock().unlock();
        });
        ConcurrentUtils.multiRun(1,()->{
            readWriteLock.writeLock().lock();
            utils.log("start write",Thread.currentThread().getId());
            ConcurrentUtils.sleep(6000);
            utils.log("end write",Thread.currentThread().getId());
            readWriteLock.writeLock().unlock();
        });
    }

}
