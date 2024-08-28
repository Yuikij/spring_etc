package com.spring.test.lab.springBean.bean的作用域.bean;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

@Component
@Scope(scopeName = SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class RequestBean {
    private String name = "RequestBean";
    private String field = "RequestBean";
}
