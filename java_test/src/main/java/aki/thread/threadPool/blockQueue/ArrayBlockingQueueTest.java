package aki.thread.threadPool.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("2");
        arrayBlockingQueue.take();
        arrayBlockingQueue.take();
        arrayBlockingQueue.put("2");
        System.out.println(arrayBlockingQueue);
    }
}
