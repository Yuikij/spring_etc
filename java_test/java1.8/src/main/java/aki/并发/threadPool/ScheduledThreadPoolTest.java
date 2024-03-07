package aki.并发.threadPool;

import aki.并发.commonClass.StopWatch;
import aki.common.utiles.ConcurrentUtils;
import com.google.common.base.Stopwatch;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

    static Stopwatch stopwatch = Stopwatch.createUnstarted();

    static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) {
        stopwatch.start();
        stopWatch.start("t1");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
//
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
//        scheduledExecutorService.schedule(() -> {
//            ConcurrentUtils.print("start 1 : " + stopwatch.elapsed().toMillis());
//            ConcurrentUtils.sleep(1000);
//            ConcurrentUtils.print("end : " + stopwatch.elapsed().toMillis());
//        }, 1, TimeUnit.SECONDS);


////周期性执行任务，间隔时间考虑任务时间
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            ConcurrentUtils.print("start 2 : " + stopwatch.elapsed().toMillis());
//            ConcurrentUtils.sleep(2000);
//            ConcurrentUtils.print("end 2 : " + stopwatch.elapsed().toMillis());
//        },1,1L,TimeUnit.SECONDS);


//周期性执行任务，间隔时间是两个任务的间隔
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            ConcurrentUtils.print("start 3 : " + stopwatch.elapsed().toMillis());
            ConcurrentUtils.sleep(2000);
            ConcurrentUtils.print("end 3 : " + stopwatch.elapsed().toMillis());
        },1,1L,TimeUnit.SECONDS);
    }
}
