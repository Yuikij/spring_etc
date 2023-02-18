package aki.thread.ThreadPool;

import aki.thread.commonClass.StopWatch;
import aki.thread.commonClass.utils.Utils;
import com.google.common.base.Stopwatch;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

    static Stopwatch stopwatch = Stopwatch.createUnstarted();

    static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) {
        stopwatch.start();
        stopWatch.start("t1");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

//        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor();
//        scheduledExecutorService.schedule(() -> {
//            Utils.print("start 1 : " + stopwatch.elapsed().toMillis());
//            Utils.sleep(1000);
//            Utils.print("end : " + stopwatch.elapsed().toMillis());
//        }, 1, TimeUnit.SECONDS);


//周期性执行任务，间隔时间考虑任务时间
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            Utils.print("start 2 : " + stopwatch.elapsed().toMillis());
            Utils.sleep(2000);
            Utils.print("end 2 : " + stopwatch.elapsed().toMillis());
        },1,1L,TimeUnit.SECONDS);


//周期性执行任务，间隔时间是两个任务的间隔
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            Utils.print("start 3 : " + stopwatch.elapsed().toMillis());
            Utils.sleep(2000);
            Utils.print("end 3 : " + stopwatch.elapsed().toMillis());
        },1,1L,TimeUnit.SECONDS);
    }
}
