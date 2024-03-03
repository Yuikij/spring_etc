package aki.并发.threadPool.blockQueue;

import aki.common.utiles.ConcurrentUtils;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolBlockTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,1,10, TimeUnit.HOURS,new LinkedBlockingDeque<>()
        );
        Runnable runnable = ()->{
            String name = Thread.currentThread().getName();
            ConcurrentUtils.print("start",name);
            ConcurrentUtils.sleep(1000000);
            ConcurrentUtils.print("end",name);
        };
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        ConcurrentUtils.print("executed");
    }
}
