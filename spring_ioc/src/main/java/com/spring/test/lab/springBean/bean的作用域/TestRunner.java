package com.spring.test.lab.springBean.bean的作用域;

import com.spring.test.lab.springBean.bean的作用域.bean.ApplicationBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestRunner implements CommandLineRunner {

    @Autowired
    private ApplicationBean applicationBean;
    private final ApplicationContext applicationContext;

    public TestRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Override
    public void run(String... args) {
        System.out.println(applicationContext.getApplicationName());
        log.info("CommandLineRunner 上下文中的 ApplicationBean:{}",applicationBean.getField());
        applicationBean.setField("ApplicationBeanChanged");
    }
}
