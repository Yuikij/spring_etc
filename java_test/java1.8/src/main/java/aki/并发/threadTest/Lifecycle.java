package aki.并发.threadTest;

import aki.common.utiles.ConcurrentUtils;

public class Lifecycle {
    private static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread thread1 = Thread.currentThread();
            ConcurrentUtils.print("进入run的线程状态", thread1.getState());
            ConcurrentUtils.sleep(1000, () -> {
                ConcurrentUtils.print("sleep中线程状态", thread1.getState());
            });
            ConcurrentUtils.print("结束sleep线程状态", thread1.getState());
            // 阻塞某个对象的锁，执行run方法，前后sleep一秒
            ConcurrentUtils.block(object,()->{
                ConcurrentUtils.print("尝试获取锁线程状态", thread1.getState());
            });
            ConcurrentUtils.sleep(100);
            synchronized (object){
                ConcurrentUtils.print("获取到锁线程状态", thread1.getState());
                ConcurrentUtils.iWait(object,()->{
                    ConcurrentUtils.print("wait后锁线程状态", thread1.getState());
                });
            }
        });
        ConcurrentUtils.print("start之前线程状态", thread.getState());
        thread.start();
        //阻塞主线程，等到thread结束
        thread.join();
        ConcurrentUtils.print("start结束线程状态", thread.getState());
    }


}
