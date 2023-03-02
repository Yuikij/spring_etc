package com.spring.test.config.threadPool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class asyncPool {

    @Value("${thread.pool.core-pool-size: 10}")
    private int corePoolSize;

    @Value("${thread.pool.maximum-pool-size: 20}")
    private int maximumPoolSize;

    @Value("${thread.pool.keep-alive-time: 60}")
    private int keepAliveTime;

    @Value("${thread.pool.queue.capacity: 1000}")
    private int capacity;

    /**
     * A custom thread pool.
     * @return
     */
    @Bean(name = "myThreadPool")
    public Executor resourceThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("myThreadPool-");
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maximumPoolSize);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setQueueCapacity(capacity);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        return executor;
    }
}
