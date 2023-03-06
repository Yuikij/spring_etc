package com.kubo.message.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 广播模式监听
 */
@Component

public class Receiver {



    @RabbitHandler
    @RabbitListener(queues = "${spring.rabbitmq.publish.push.queues:test-message}")
    public void process(String message) {
        System.out.println("FanoutReceiver消费者收到消息  : " + message.toString());
    }


}
