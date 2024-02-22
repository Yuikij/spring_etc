package aki.并发.producerAndConsumer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        try {
            // 业务方法....
            // 1.进入等待状态

            new Thread(()->{
                lock.lock();
                try {
                    condition.await(20L, TimeUnit.SECONDS);
//                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }).start();
            // 2.唤醒操作

        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signal();
            lock.unlock();
        }).start();
    }
}
