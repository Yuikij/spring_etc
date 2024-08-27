package com.spring.test.lab.springBean.bean的作用域.bean;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@Data
public class PrototypeBean {
    private String name = "prototypeBean";
    private String field = "bean";
}
