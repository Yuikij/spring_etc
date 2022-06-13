package com.spring.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 测试bean的生命周期
 */
@Service
public class BeanTest implements InitializingBean, BeanNameAware, BeanFactoryAware, DisposableBean {

    @Autowired
    private ZAutowireHelper ZAutowireHelper;

    @Override
    public void setBeanName(String name) {
        System.out.println(String.format("beanName:%s", name));
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }


    public void initMethod() {
        System.out.println("initMethod");
    }

    @PreDestroy
    public void PreDestroy() {
        System.out.println("PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod");
    }

}
