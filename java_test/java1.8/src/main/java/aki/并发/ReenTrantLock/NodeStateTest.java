package aki.并发.ReenTrantLock;

import aki.common.utiles.ConcurrentUtils;

import java.util.concurrent.locks.ReentrantLock;

public class NodeStateTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        ConcurrentUtils.multiRun(1,()->{
            Thread.currentThread().setName("t1");
            reentrantLock.lock();
            ConcurrentUtils.sleep(1000);
            reentrantLock.unlock();
        });
        ConcurrentUtils.sleep(200);
        ConcurrentUtils.multiRun(1,()->{
            Thread.currentThread().setName("t2");
            reentrantLock.lock();
            ConcurrentUtils.sleep(1000);
            reentrantLock.unlock();
        });
    }
}
