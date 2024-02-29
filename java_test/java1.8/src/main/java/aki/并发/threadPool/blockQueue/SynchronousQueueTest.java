package aki.并发.threadPool.blockQueue;

import aki.并发.commonClass.utils.Utils;
import org.testng.annotations.Test;


import java.util.concurrent.SynchronousQueue;


public class SynchronousQueueTest {

    @Test
    public static void testTake() {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
//        第一次take 阻塞,先put也一样
        Utils.multiRun(1,()->{
            Utils.sleep(2000);
            try {
                System.out.println("尝试take1");
                System.out.println(synchronousQueue.take());
                System.out.println("take1 结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //        第二次take 阻塞
        Utils.multiRun(1,()->{
            Utils.sleep(3000);
            try {
                System.out.println("尝试take2");
                System.out.println(synchronousQueue.take());
                System.out.println("take2 结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //        第一次put 非公平的话就后到先配对
        Utils.multiRun(1,()->{
            Utils.sleep(4000);
                System.out.println("尝试put");
            try {
                synchronousQueue.put("123");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("put 结束");
        });
    }

    @Test
    public static void testPut() {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
//        第一次take 阻塞
        Utils.multiRun(1,()->{
            Utils.sleep(2000);
            System.out.println("尝试offer1，"+synchronousQueue.offer("111"));
            System.out.println("尝试offer1 结束");
        });
        //        第二次take 阻塞
        Utils.multiRun(1,()->{
            Utils.sleep(4000);
            System.out.println("尝试offer2，"+synchronousQueue.offer("222"));
            System.out.println("尝试offer2 结束");
        });
        //        第一次put 非公平的话就不保证顺序
        Utils.multiRun(1,()->{
            Utils.sleep(3000);
            System.out.println("尝试take");
            try {
                synchronousQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("take 结束");
        });
    }

    @Test
    public static void testOfferAndPoll() {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
//        第一次offer 阻塞
        Utils.multiRun(1,()->{
            Utils.sleep(2000);
            System.out.println("尝试offer1，"+synchronousQueue.offer("111"));
            System.out.println("尝试offer1 结束");
        });
        //        第二次offer 阻塞
        Utils.multiRun(1,()->{
            Utils.sleep(4000);
            System.out.println("尝试offer2，"+synchronousQueue.offer("222"));
            System.out.println("尝试offer2 结束");
        });
        //        第一次poll 非公平的话就不保证顺序
        Utils.multiRun(1,()->{
            Utils.sleep(3000);
            System.out.println("尝试poll,"+  synchronousQueue.poll());

            System.out.println("poll 结束");
        });
    }


    public static void main(String[] args) throws InterruptedException {
        testOfferAndPoll();
    }
}
