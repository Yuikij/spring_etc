package com.spring.test.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ZAutowireHelper {

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct:AutowireHelper");
    }
}
