package com.kubo.common.redis.template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kubo.common.redis.service.RedisService;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

@SpringBootTest
@ComponentScan(basePackages = {"com.kubo"})
class TemplateApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
        redisService.setCacheObject("123", "kubo");
        System.out.println(redisService.getCacheObject("123").toString());
    }

}
