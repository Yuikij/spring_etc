package aki.并发.threadTest;

import aki.并发.commonClass.utils.Utils;
import com.google.common.base.Stopwatch;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ICallable {

    static Stopwatch stopwatch = Stopwatch.createUnstarted();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(() -> {
            Utils.sleep(1000);
            return "123";
        });
        stopwatch.start();
        //创建线程
        new Thread(task).start();
        //调用get()方法阻塞主线程
        String str = task.get();
        Duration elapsed = stopwatch.elapsed();
        Utils.sleep(1000);
        Duration elapsed2 = stopwatch.elapsed();
        System.out.println("hello :" + str);
        System.out.println("time :" + elapsed.getSeconds());
        System.out.println("time :" + stopwatch.stop());
    }
}
