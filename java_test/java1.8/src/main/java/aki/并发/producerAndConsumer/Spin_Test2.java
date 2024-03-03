package aki.并发.producerAndConsumer;

import aki.common.utiles.ConcurrentUtils;

import java.util.ArrayList;
import java.util.List;

public class Spin_Test2 {

    static class Queue {
        static volatile List<Integer> list = new ArrayList<>();
        static final Object lock = new Object();
        static Integer get() {
            Integer res = null;
            if (list.size() != 0) {
                res = list.remove(0);
            }

            return res;
        }

        static boolean set(Integer integer) {
            if (list.size() == 0) {
                list.add(integer);
                return true;
            }
            return false;
        }


        public static void main(String[] args) {
            Runnable set = () -> {
                for (int i = 0; i < 10000; i++) {
                    while (!Queue.set(i)){
                        Queue.set(i);
                    }
                }
            };

            Runnable get = () -> {
                while (true) {
                    Integer integer = null;
                    while (Queue.get()==null){
                        integer = Queue.get();
                    }
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