package aki.并发.threadTest;

import aki.common.utiles.ConcurrentUtils;
import com.google.common.base.Stopwatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ICallable2 {

    static Stopwatch stopwatch = Stopwatch.createUnstarted();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(() -> {
            ConcurrentUtils.sleep(1000);
            System.out.println("开始执行任务，计划返回：123");
            return "123";
        });
        //创建线程
        new Thread(task).start();
        System.out.println("当前执行"+(task.isDone()?"已完成":"未完成"));
        //调用get()方法阻塞主线程
        String str = task.get();
        System.out.println("执行结果 :" + str);
    }
}
