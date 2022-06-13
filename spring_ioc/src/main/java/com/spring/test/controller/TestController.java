package com.spring.test.controller;

import com.spring.test.TestApplication;
import com.spring.test.bean.BeanTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestController {

    private  BeanTest beanTest;


    @Autowired
    public void setBeanTest(BeanTest beanTest) {
        this.beanTest = beanTest;
    }

    @GetMapping("/1")
    public void test1(){
        System.out.println(beanTest);
    }
}
