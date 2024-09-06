package com.spring.test.lab.springBean.concurrent.parallelStream;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static com.spring.test.utils.CommonUtils.sleep;

@SpringBootTest
@Log4j2
public class LabTest {
    @Test
    void runTest() throws InterruptedException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        CountDownLatch latch = new CountDownLatch(2);
        ForkJoinPool customThreadPool = new ForkJoinPool(3);
        new Thread(()->{
            try {
                customThreadPool.submit(()->{
                    numbers.parallelStream().forEach(e->{
                        log.info("start do parallel");
                        sleep(10000);
                        log.info("end do parallel");
                    });
                }).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            latch.countDown();
        }).start();

        new Thread(()->{
            try {
                customThreadPool.submit(()->{
                    numbers.parallelStream().forEach(e->{
                        log.info("start do parallel");
                        sleep(10000);
                        log.info("end do parallel");
                    });
                }).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            latch.countDown();
        }).start();


        latch.await();
    }
}
