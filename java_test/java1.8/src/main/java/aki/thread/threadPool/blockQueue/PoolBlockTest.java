package aki.thread.threadPool.blockQueue;

import aki.thread.commonClass.utils.Utils;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolBlockTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,1,10, TimeUnit.HOURS,new LinkedBlockingDeque<>()
        );
        Runnable runnable = ()->{
            String name = Thread.currentThread().getName();
            Utils.print("start",name);
            Utils.sleep(1000000);
            Utils.print("end",name);
        };
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        Utils.print("executed");
    }
}
