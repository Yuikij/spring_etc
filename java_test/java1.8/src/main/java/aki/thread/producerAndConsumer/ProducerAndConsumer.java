package aki.thread.producerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用一个Condition对象会造成死锁，解决：
 *  - signal改成signalAll
 *  - 用两个Condition对象
 * @param <T>
 */
public class ProducerAndConsumer<T> {

    private final Lock lock = new ReentrantLock();
    // 生产者的 Condition 对象
    private final Condition producerCondition = lock.newCondition();
    // 消费者的 Condition 对象
    private final Condition consumerCondition = lock.newCondition();

    interface ConditionCheck {
        boolean check();
    }

    interface DoProduce<T> {
        void produce(T integer);
    }

    public void produce(DoProduce<T> doProduce, ConditionCheck condition, T i) {
        try {
            lock.lock();
            while (condition.check()) { // 注意不能是 if 判断
                producerCondition.await();
            }
            doProduce.produce(i);
            consumerCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumer(Runnable runnable, ConditionCheck condition) {
        try {
            lock.lock();
            while (condition.check()) { // 注意不能是 if 判断
                consumerCondition.await();
            }
            runnable.run();
            producerCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
