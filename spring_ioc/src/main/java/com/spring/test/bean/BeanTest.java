package com.spring.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
//import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.security.auth.login.Configuration;

/**
 * 测试bean的生命周期
 */
@Service
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope(WebApplicationContext.SCOPE_SESSION)

public class BeanTest implements InitializingBean, BeanNameAware, BeanFactoryAware, DisposableBean {

    public BeanTest() {
        System.out.println("--BeanTest--");
    }

    @Autowired
    private ZAutowireHelper ZAutowireHelper;

//    @Transactional
    public void aopTest(){

    }

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
