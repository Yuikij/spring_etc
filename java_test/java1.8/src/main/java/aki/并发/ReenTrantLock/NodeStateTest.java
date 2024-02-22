package aki.并发.ReenTrantLock;

import aki.并发.commonClass.utils.Utils;

import java.util.concurrent.locks.ReentrantLock;

public class NodeStateTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        Utils.multiRun(1,()->{
            Thread.currentThread().setName("t1");
            reentrantLock.lock();
            Utils.sleep(1000);
            reentrantLock.unlock();
        });
        Utils.sleep(200);
        Utils.multiRun(1,()->{
            Thread.currentThread().setName("t2");
            reentrantLock.lock();
            Utils.sleep(1000);
            reentrantLock.unlock();
        });
    }
}
