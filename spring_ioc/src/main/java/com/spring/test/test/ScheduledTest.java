package com.spring.test.test;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTest {

    @Scheduled(cron = "*/2 * * * * ?")
    void checkScheduledA() throws InterruptedException {
        System.out.println("start checkScheduledA");
        Thread.sleep(10000);
        System.out.println("end checkScheduledA");
    }

    @Scheduled(cron = "*/2 * * * * ?")
    void checkScheduledB() throws InterruptedException {
        System.out.println("start checkScheduledB");
        Thread.sleep(10000);
        System.out.println("end checkScheduledB");
    }

}
