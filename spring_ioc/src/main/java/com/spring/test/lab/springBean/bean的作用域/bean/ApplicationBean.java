package com.spring.test.lab.springBean.bean的作用域.bean;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.web.context.WebApplicationContext.SCOPE_APPLICATION;

@Component
@Scope(SCOPE_APPLICATION)
@Data
public class ApplicationBean {
    private String name = "ApplicationBean";
    private String field = "ApplicationBean";
}
