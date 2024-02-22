package aki.并发.ReenTrantLock;

import aki.并发.commonClass.utils.Utils;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Utils.multiRun(1, () -> {
            reentrantLock.lock();
            Utils.print("lock");
            Utils.sleep(2000);
            reentrantLock.unlock();
            Utils.print("unlock");
        });
        Utils.sleep(500);
        Utils.multiRun(1, () -> {
            boolean tryLock = reentrantLock.tryLock();
            Utils.print("tryLock", tryLock);
            reentrantLock.lock();
            Utils.print("lock");
        });
    }
}
