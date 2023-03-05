package com.spring.test.config.threadPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class SchedulingPool {
    @Bean(name = "myThreadPoolTaskScheduler")
    public ThreadPoolTaskScheduler myThreadPoolTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setThreadNamePrefix("myScheduler-");
        taskScheduler.setPoolSize(10);
        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return taskScheduler;
    }

//    @Bean(name = "myThreadPoolTaskScheduler2")
//    public TaskScheduler myThreadPoolTaskScheduler2() {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setThreadNamePrefix("myScheduler-");
//        taskScheduler.setPoolSize(10);
//        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        return taskScheduler;
//    }
}
