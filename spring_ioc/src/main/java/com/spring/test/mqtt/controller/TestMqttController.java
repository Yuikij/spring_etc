package com.spring.test.mqtt.controller;

import com.spring.test.mqtt.service.Handler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestMqttController {

    public static List<Handler> handlers = new ArrayList<>();

    @GetMapping("/mqtt/1")
    public void test1(){
        handlers.forEach(Handler::callBack);

    }

}
