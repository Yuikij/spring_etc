package com.spring.test.lab.springBean.bean的作用域.bean;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.web.context.WebApplicationContext.SCOPE_APPLICATION;

@Component
@Scope("websocket")
@Data
public class WebsocketBean {
    private String name = "WebsocketBean";
    private String field = "WebsocketBean";
}
