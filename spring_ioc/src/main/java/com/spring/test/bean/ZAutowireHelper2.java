package com.spring.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ZAutowireHelper2 {
    @Autowired
    private ZAutowireHelper zAutowireHelper;

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct:AutowireHelper2");
    }
}
