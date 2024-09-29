package com.spring.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;



@Configuration
public class GlobalThreadPoolConfiguration {

    @Value("${thread.pool.core-pool-size: 20}")
    private int corePoolSize;

    @Value("${thread.pool.maximum-pool-size: 40}")
    private int maximumPoolSize;

    @Value("${thread.pool.keep-alive-time: 60}")
    private long keepAliveTime;

    @Value("${thread.pool.queue.capacity: 1000}")
    private int capacity;

    /**
     * A custom thread pool.
     * @return
     */
    @Bean(name = "threadPool")
    public Executor threadPool() {
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize, keepAliveTime,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(capacity),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

}
