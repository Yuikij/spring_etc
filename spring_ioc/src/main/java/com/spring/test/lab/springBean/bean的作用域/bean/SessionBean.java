package com.spring.test.lab.springBean.bean的作用域.bean;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

@Component
@Scope(SCOPE_SESSION)
@Data
public class SessionBean {
    private String name = "SessionBean";
    private String field = "SessionBean";
}
