//package com.spring.test;
//
//
//import com.enbo.config.MyService;
//import com.spring.test.utils.CommonUtils;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ScheduledFuture;
//
//@SpringBootTest
//public class AutowiredTest {
//
//
//    @Autowired
//    private ThreadPoolTaskScheduler taskScheduler;
//
//    @Autowired
//    private MyService myService;
//
//    @Test
//    void test() {
//        myService.printMessage();
//    }
//    @Test
//    void testScheduler() throws ExecutionException, InterruptedException {
//        ScheduledFuture<?> scheduledFuture = taskScheduler.scheduleAtFixedRate(() -> {
//            CommonUtils.print("start",Thread.currentThread().getName());
//            CommonUtils.sleep(10000);
//            CommonUtils.print("end",Thread.currentThread().getName());
//        }, 2000);
//
//        scheduledFuture.get();
//    }
//}
