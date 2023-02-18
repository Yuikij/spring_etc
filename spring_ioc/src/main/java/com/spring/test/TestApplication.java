package com.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@SpringBootApplication
@EnableScheduling
public class TestApplication {


//    @Autowired
//    private sLock sLock;

//    @Resource
//    private Lock lock;

    @Autowired
    private Lock sLock;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}

@Configuration
class Config{
    @Bean
    public Lock Lock(){
        return new sLock();
    }
}
interface Lock{}

class sLock implements Lock{}