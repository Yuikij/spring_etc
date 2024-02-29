package aki.并发.threadPool;

import aki.demo.util.ToolUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            ToolUtils.sleep(2000);
            System.out.println("run");
        };
        executorService.execute(runnable);
        System.out.println("execute1");
        executorService.execute(runnable);
        System.out.println("execute1");
//        System.out.println("submit1");
//        executorService.submit(runnable);
//        System.out.println("submit2");
//        executorService.submit(runnable);
//        System.out.println("submit3");

    }
}
