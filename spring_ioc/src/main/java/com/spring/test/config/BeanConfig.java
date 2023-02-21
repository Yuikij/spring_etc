package com.spring.test.config;


import com.spring.test.service.BeanTest;
import com.spring.test.service.BeanTestShita;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public BeanTest beanTestKubo(){
        return new BeanTestShita();
    }
}

