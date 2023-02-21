package com.spring.test;

import com.spring.test.bean.BeanTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringIocApplication.class);
        BeanTest bean = context.getBean(BeanTest.class);
        BeanTest bean2 = context.getBean(BeanTest.class);
        System.out.println(bean==bean2);
    }
}
