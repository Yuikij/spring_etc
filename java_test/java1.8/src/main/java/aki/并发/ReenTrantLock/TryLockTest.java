package aki.并发.ReenTrantLock;

import aki.common.utiles.ConcurrentUtils;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ConcurrentUtils.multiRun(1, () -> {
            reentrantLock.lock();
            ConcurrentUtils.print("lock");
            ConcurrentUtils.sleep(2000);
            reentrantLock.unlock();
            ConcurrentUtils.print("unlock");
        });
        ConcurrentUtils.sleep(500);
        ConcurrentUtils.multiRun(1, () -> {
            boolean tryLock = reentrantLock.tryLock();
            ConcurrentUtils.print("tryLock", tryLock);
            reentrantLock.lock();
            ConcurrentUtils.print("lock");
        });
    }
}
