package com.spring.test.lab.springBean.bean的作用域;

import com.spring.test.lab.springBean.bean的作用域.bean.PrototypeBean;
import com.spring.test.lab.springBean.bean的作用域.bean.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private SingletonBean singletonBean;
    @Autowired
    private PrototypeBean prototypeBean;
    @Autowired
    private PrototypeBean prototypeBean2;
    @Autowired
    private SingletonBean singletonBean2;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("开始执行bean作用域实验");
        System.out.println("singletonBean: " + singletonBean);
        System.out.println("prototypeBean: " + prototypeBean);
        singletonBean.setField("changed");
        prototypeBean.setField("changed");
        System.out.println("prototypeBean2: " + prototypeBean2);
        System.out.println("singletonBean2: " + singletonBean2);
    }
}
