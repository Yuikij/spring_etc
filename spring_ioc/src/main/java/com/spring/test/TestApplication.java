package com.spring.test;

import com.spring.test.bean.BeanTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
//
//    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
//    public BeanTest beanTest(){
//        return new BeanTest();
//    }
}
