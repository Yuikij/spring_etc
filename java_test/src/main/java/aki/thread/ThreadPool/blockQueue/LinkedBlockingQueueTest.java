package aki.thread.ThreadPool.blockQueue;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(1);

        linkedBlockingQueue.put(":");
    }
}
