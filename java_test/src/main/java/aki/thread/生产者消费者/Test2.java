package aki.thread.生产者消费者;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test2 {

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

            new Thread(() -> {
                while (true) {
                    Integer integer = Queue.get();
                    if (integer != null) {
                        System.out.println(integer);
                    }
                }
            }).start();

            new Thread(() -> {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                for (int i = 0; i < 10000; i++) {
                    Queue.set(i);
                }
            }).start();

        }
    }
}