package com.spring.test.task;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "cloud_pro")
//天气识别
public class RabbitMqWeatherReceiver {



    @RabbitHandler
    public void process(String message) {
        System.out.println("------------收到rbmq---------------");
        System.out.println(message);
    }


}
