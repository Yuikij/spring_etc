package aki.thread.threadTest;

import aki.thread.commonClass.utils.Utils;

public class Lifecycle {
    private static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread thread1 = Thread.currentThread();
            Utils.print("进入run的线程状态", thread1.getState());
            Utils.sleep(1000, () -> {
                Utils.print("sleep中线程状态", thread1.getState());
            });
            Utils.print("结束sleep线程状态", thread1.getState());
            // 阻塞某个对象的锁，执行run方法，前后sleep一秒
            Utils.block(object,()->{
                Utils.print("尝试获取锁线程状态", thread1.getState());
            });
            Utils.sleep(100);
            synchronized (object){
                Utils.print("获取到锁线程状态", thread1.getState());
                Utils.iWait(object,()->{
                    Utils.print("wait后锁线程状态", thread1.getState());
                });
            }
        });
        Utils.print("start之前线程状态", thread.getState());
        thread.start();
        //阻塞主线程，等到thread结束
        thread.join();
        Utils.print("start结束线程状态", thread.getState());
    }


}
