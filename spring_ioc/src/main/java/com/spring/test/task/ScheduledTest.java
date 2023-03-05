package com.spring.test.task;

import com.spring.test.utils.CommonUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTest {

    @Scheduled(cron = "*/5 * * * * ?")
//    @Async("myThreadPoolTaskScheduler")
    void checkScheduledA() throws InterruptedException {
        String name = Thread.currentThread().getName();
        CommonUtils.print("start checkScheduledA",name);
//        Thread.sleep(20000);
        CommonUtils.print("end checkScheduledA",name);
    }

//    @Scheduled(cron = "*/2 * * * * ?")
//    void checkScheduledB() throws InterruptedException {
//        String name = Thread.currentThread().getName();
//        CommonUtils.print("start checkScheduledB",name);
//        Thread.sleep(20000);
//        CommonUtils.print("end checkScheduledB",name);
//    }
//
//    @Scheduled(cron = "*/2 * * * * ?")
//    void checkScheduledC() throws InterruptedException {
//        String name = Thread.currentThread().getName();
//        CommonUtils.print("start checkScheduledC",name);
//        Thread.sleep(20000);
//        CommonUtils.print("end checkScheduledC",name);
//    }

}
