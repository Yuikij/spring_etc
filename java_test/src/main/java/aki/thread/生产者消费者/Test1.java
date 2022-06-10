package aki.thread.生产者消费者;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    static class Queue {
        static volatile List<Integer> list = new ArrayList<>();

        static synchronized Integer get() {
            if (list.size() > 0) {
                return list.remove(0);
            } else {
                return null;
            }
        }

        static synchronized void set(Integer integer) {
            if (list.size() == 0) {
                list.add(integer);
            }
        }
    }


    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                System.out.println(Queue.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                for (int i = 0; i < 10000; i++) {
                    Queue.set(i);
                }
            }
        }).start();

    }
}
