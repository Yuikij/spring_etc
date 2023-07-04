 package com.spring.test.config.rabbitMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("192.168.9.148");
    }

    @Bean
    public RabbitAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue() {
        return new Queue("cloud_pro");
    }

    @Bean
    public Queue webQueue() {
        return new Queue("web_pro");
    }

        //Direct交换机
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("cloud_pro", true, false);
    }


        //绑定  将队列和交换机绑定, 并设置用于匹配键
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(myQueue()).to(directExchange()).withQueueName();
    }

    @Bean
    Binding bindingDirect2() {
        return BindingBuilder.bind(webQueue()).to(directExchange()).withQueueName();
    }
}
