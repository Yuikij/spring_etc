package com.spring.test.mqtt.controller;

import com.spring.test.mqtt.service.Handler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestMqtt2Controller {

    private String callBack = "callBack";


    @GetMapping("/mqtt/2")
    public void test2() {
        Handler handler = () -> System.out.println(callBack);
        TestMqttController.handlers.add(handler);
    }

}
