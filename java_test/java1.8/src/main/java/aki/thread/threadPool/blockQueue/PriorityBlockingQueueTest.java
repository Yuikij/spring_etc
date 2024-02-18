package aki.thread.threadPool.blockQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {

    static class Task implements Runnable, Comparable<Task> {

        private int priority;

        @Override
        public void run() {

        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(o.priority, this.priority);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Task> taskPriorityBlockingQueue = new PriorityBlockingQueue<>();
        taskPriorityBlockingQueue.take();
        taskPriorityBlockingQueue.put(new Task());
    }
}
