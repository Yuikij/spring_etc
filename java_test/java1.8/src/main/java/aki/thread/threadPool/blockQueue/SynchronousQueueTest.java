package aki.thread.threadPool.blockQueue;

import aki.thread.commonClass.utils.Utils;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();


        Utils.multiRun(1,()->{
            Utils.sleep(3000);
            try {
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Utils.multiRun(1,()->{
            Utils.sleep(2000);
            try {
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Utils.multiRun(1,()->{
            Utils.sleep(1000);
            try {
                synchronousQueue.put("1234");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        synchronousQueue.put("123");
//        System.out.println(synchronousQueue.take());
//        System.out.println(synchronousQueue.take());
        System.out.println(synchronousQueue);
    }
}
