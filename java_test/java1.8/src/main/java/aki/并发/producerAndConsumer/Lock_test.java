package aki.并发.producerAndConsumer;

import aki.common.utiles.ConcurrentUtils;

import java.util.ArrayList;
import java.util.List;

public class Lock_test {

    /**
     * notify：只支持一个消费者和一个生产者
     * 如果多个消费者的话
     * 1。size > 0 ，生产者wait
     * 2. 消费者 -> size = 0 , 唤醒
     * 3. 此时有多个消费者wait，唤醒之后进入while 继续wait
     * ----------------------
     * 改进：notifyAll
     */
    static class Queue {
        static final List<Integer> list = new ArrayList<>();

        static final Object obj = new Object();

        static ConcurrentUtils utils = new ConcurrentUtils(false);

        static Integer get() throws InterruptedException {
            synchronized (obj) {
                utils.log("start get");
                while (list.size() == 0) {
                    utils.log("start get wait");
                    obj.wait();
                    utils.log("end get wait");
                }
                Integer remove = list.remove(0);
                utils.log("get", remove);
                obj.notifyAll();
                return remove;
            }
        }

        static void set(Integer integer) throws InterruptedException {
            synchronized (obj) {
                utils.log("start set");
                if (list.size() != 0) obj.wait();
                list.add(integer);
                utils.log("set", integer);
                obj.notify();
                utils.log("end set");
            }
        }
    }


    public static void main(String[] args) {
        Runnable get = () -> {
            while (true) {
                try {
                    System.out.println(Queue.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable set = () -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Queue.set(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ConcurrentUtils.multiRun(1, set);
        ConcurrentUtils.multiRun(199, get);
    }


}
