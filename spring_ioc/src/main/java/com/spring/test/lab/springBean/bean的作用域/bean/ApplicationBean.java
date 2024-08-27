package com.spring.test.lab.springBean.bean的作用域.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.web.context.WebApplicationContext.SCOPE_APPLICATION;

@Component
@Scope(SCOPE_APPLICATION)
public class ApplicationBean {
}
