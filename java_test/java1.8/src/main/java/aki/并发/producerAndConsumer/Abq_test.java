package aki.并发.producerAndConsumer;

import aki.并发.commonClass.utils.Utils;

import java.util.concurrent.SynchronousQueue;

public class Abq_test {
    static SynchronousQueue<Integer> queue = new SynchronousQueue<>();


    public static void main(String[] args) {
        Runnable get = () -> {
//            for (int i = 0; i < 100; i++) {

            System.out.println(queue.poll());

//            }
        };

        Runnable set = () -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Utils.multiRun(1, set);
        Utils.multiRun(199, get);
    }


}
