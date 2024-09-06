package com.spring.test.lab.springBean.concurrent.completableFuture;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static com.spring.test.utils.CommonUtils.sleep;

@SpringBootTest
@Log4j2
public class LabTest {
    @Test
    void runTest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(100);
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(1);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                executor.submit(() -> {
                    log.info("start do parallel");
                    sleep(10000);
                    log.info("end do parallel");
                    latch.countDown();
                });
            }).start();
        }
        latch.await();
    }
}
