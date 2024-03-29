package aki.并发.threadPool.blockQueue;


import aki.common.utiles.ConcurrentUtils;
import org.testng.annotations.Test;


import java.util.concurrent.SynchronousQueue;


public class SynchronousQueueTest {

    @Test
    public static void testTake() {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
//        第一次take 阻塞,先put也一样
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(2000);
            try {
                System.out.println("尝试take1");
                System.out.println(synchronousQueue.take());
                System.out.println("take1 结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //        第二次take 阻塞
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(3000);
            try {
                System.out.println("尝试take2");
                System.out.println(synchronousQueue.take());
                System.out.println("take2 结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //        第一次put 非公平的话就后到先配对
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(4000);
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
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(2000);
            System.out.println("尝试offer1，"+synchronousQueue.offer("111"));
            System.out.println("尝试offer1 结束");
        });
        //        第二次take 阻塞
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(4000);
            System.out.println("尝试offer2，"+synchronousQueue.offer("222"));
            System.out.println("尝试offer2 结束");
        });
        //        第一次put 非公平的话就不保证顺序
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(3000);
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
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(2000);
            System.out.println("尝试offer1，"+synchronousQueue.offer("111"));
            System.out.println("尝试offer1 结束");
        });
        //        第二次offer 阻塞
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(4000);
            System.out.println("尝试offer2，"+synchronousQueue.offer("222"));
            System.out.println("尝试offer2 结束");
        });
        //        第一次poll 非公平的话就不保证顺序
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(3000);
            System.out.println("尝试poll,"+  synchronousQueue.poll());

            System.out.println("poll 结束");
        });
    }

    @Test
    public static void testMultiPut() {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
//        第一次take 阻塞,先put也一样
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            ConcurrentUtils.multiRun(1,()->{
                ConcurrentUtils.sleep(2000);
                try {
                    System.out.println("尝试put");
                    synchronousQueue.put(finalI +"");
                    System.out.println("put 结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        ConcurrentUtils.multiRun(5,()->{
            ConcurrentUtils.sleep(2000);
            try {
                System.out.println("尝试put");
                synchronousQueue.put("123");
                System.out.println("put 结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(123);
        ConcurrentUtils.multiRun(1,()->{
            ConcurrentUtils.sleep(2000);
            try {
                System.out.println("尝试put");
                synchronousQueue.put("123");
                System.out.println("put 结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        testMultiPut();
    }
}
