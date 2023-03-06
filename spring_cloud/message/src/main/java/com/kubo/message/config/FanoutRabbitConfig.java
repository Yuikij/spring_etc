//package com.kubo.message.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 广播模式RabbitMq配置
// */
//@Configuration
//public class FanoutRabbitConfig {
//    @Value("${spring.rabbitmq.listener.queues}")
//    private String queueName;
//    @Value("${spring.rabbitmq.listener.exchange}")
//    private String exchangeName;
//
//    @Bean
//    public Queue queue() {
//        return new Queue(queueName,false,false,true);
//    }
//
//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange(exchangeName);
//    }
//
//    @Bean
//    Binding bindingExchange() {
//        return BindingBuilder.bind(queue()).to(fanoutExchange());
//    }
//}
