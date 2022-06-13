package com.spring.test.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class IPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanTest")) {
            log.info("postProcessBeforeInitialization:{},{}", bean, beanName);

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanTest")) {
            log.info("postProcessBeforeInitialization:{},{}", bean, beanName);
        }
        return bean;
    }
}
