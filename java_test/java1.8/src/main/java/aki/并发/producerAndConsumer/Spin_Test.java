package aki.并发.producerAndConsumer;

import aki.common.utiles.ConcurrentUtils;

import java.util.ArrayList;
import java.util.List;

public class Spin_Test {

    static class Queue {
        static volatile List<Integer> list = new ArrayList<>();
        static final Object lock = new Object();
        static Integer get() {
            Integer res = null;
            while (list.size() == 0) {
            }
            res = list.remove(0);
            return res;
        }

        static void set(Integer integer) {
            while (list.size() != 0) {
            }
            list.add(integer);
        }


        public static void main(String[] args) {
            Runnable set = () -> {
                ConcurrentUtils.sleep(1000);
                for (int i = 0; i < 10000; i++) {
                    Queue.set(i);
                }
            };

            Runnable get = () -> {
                while (true) {
                    Integer integer = Queue.get();
                    if (integer != null) {
                        System.out.println(integer);
                    }
                }
            };
            ConcurrentUtils.multiRun(1, set);
            ConcurrentUtils.multiRun(1, get);
        }


    }
}