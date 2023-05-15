package com.kubo.common.redis.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 模板模块，用于一些测试
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.kubo"})
public class TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

}
