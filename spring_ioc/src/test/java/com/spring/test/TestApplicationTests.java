package com.spring.test;

import com.spring.test.bean.多态.Base;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

@SpringBootTest
class TestApplicationTests {
    @Autowired
    private Base base;

    @Resource(name = "threadPool")
    private Executor threadPool;

    @Test
    void testStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        stopWatch.start();
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println(stopWatch);
    }

    @Test
    void contextLoads() {

        threadPool.execute(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(22);
        });

        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("开始执行任务，计划返回：123");
            return "123";
        });
        threadPool.execute(task);
        task.cancel(true);


//        new Thread(()->{
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(22);
//        }).start();

        System.out.println(11);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testBean(){
        Base base1 = base;
        System.out.println(base1);
    }

}
