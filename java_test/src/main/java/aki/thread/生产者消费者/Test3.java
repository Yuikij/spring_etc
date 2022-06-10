package aki.thread.生产者消费者;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    static class Queue {
        static final List<Integer> list = new ArrayList<>();

        static  Integer get() throws InterruptedException {
           synchronized (list){
               if (list.size()==0) list.wait();
               list.notify();
               return list.remove(0);
           }
        }

        static synchronized void set(Integer integer) throws InterruptedException {
            synchronized (list){
                if (list.size()!=0) list.wait();
                list.notify();
                list.add(integer);
            }
        }
    }


    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(Queue.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
//            while (true) {
                for (int i = 0; i < 10000; i++) {
                    try {
                        Queue.set(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//            }
        }).start();

    }
}
