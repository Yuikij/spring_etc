package com.spring.test.shiori;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

@SpringBootTest
class SpringAopApplicationTests {

    @Test
    void contextLoads() {
        test();
        System.out.println(123);
    }


    @Async
    void test(){
        try {
            Thread.sleep(10000);
            System.out.println(111);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
