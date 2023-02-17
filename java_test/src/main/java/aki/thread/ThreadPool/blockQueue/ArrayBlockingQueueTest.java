package aki.thread.ThreadPool.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.put("2");
        System.out.println(arrayBlockingQueue);
    }
}
