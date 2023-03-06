package com.kubo.message.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 直连模式RabbitMq配置
 */
@Configuration
public class DirectRabbitConfig {

//    @Value("${spring.rabbitmq.publish.push.exchange}")
//    private String mqExchange;
//    @Value("${spring.rabbitmq.publish.push.routing}")
//    private String mqRoutingKey;
    @Value("${spring.rabbitmq.publish.push.queues:test-message}")
    private String mqName;

    //队列
    @Bean
    public Queue directQueue() {
        return new Queue(mqName, true);
    }

//    //Direct交换机
//    @Bean
//    DirectExchange directExchange() {
//        return new DirectExchange(mqExchange, true, false);
//    }
//
//    //绑定  将队列和交换机绑定, 并设置用于匹配键
//    @Bean
//    Binding bindingDirect() {
//        return BindingBuilder.bind(directQueue()).to(directExchange()).with(mqRoutingKey);
//    }
}
