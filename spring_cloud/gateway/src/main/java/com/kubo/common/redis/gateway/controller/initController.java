package com.kubo.common.redis.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class initController {
    @Value("${test}")

    private String test;

    @Value("${test2}")
    private String test2;

    @GetMapping("test")
    public String test() {
        return test;
    }

}
