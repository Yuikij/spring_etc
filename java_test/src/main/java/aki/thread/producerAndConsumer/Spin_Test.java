package aki.thread.producerAndConsumer;

import aki.thread.commonClass.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Spin_Test {

    static class Queue {
        static volatile List<Integer> list = new ArrayList<>();
        //        static final Vector<Integer> list = new Vector<>();
        static final Object lock = new Object();

        static Integer get() {
            Integer res = null;
//            synchronized (lock) {
            while (list.size() == 0) {
            }
            res = list.remove(0);
//            }
            return res;
        }

        static void set(Integer integer) {
//            synchronized (lock) {
            while (list.size() != 0) {

            }
            list.add(integer);
//            }
        }


        public static void main(String[] args) {
            Runnable set = () -> {
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
            Utils.multiRun(100, set);
            Utils.multiRun(100, get);

        }


    }
}