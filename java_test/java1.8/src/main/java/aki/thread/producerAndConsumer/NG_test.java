package aki.thread.producerAndConsumer;

import aki.thread.commonClass.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class NG_test {

    static class Queue {
        static volatile List<Integer> list = new ArrayList<>();


        /**
         * 同步锁要和线程通讯调配合
         *
         * @return
         */
        static synchronized Integer get() {
//            if (list.size() > 0) {
//                return list.remove(0);
//            } else {
//                return null;
//            }

            while (list.isEmpty()) {

            }
            return list.remove(0);
        }

        static synchronized void set(Integer integer) {
            if (list.size() == 0) {
                list.add(integer);
            }
        }
    }


    public static void main(String[] args) {
        Runnable set = () -> {
            for (int i = 0; i < 10000; i++) {
                Queue.set(i);
            }
        };

        Runnable get = () -> {
            while (true) {
                System.out.println(Queue.get());
            }
        };
        Utils.multiRun(1, set);
        Utils.multiRun(1, get);
    }
}
