//package com.kubo.message.producer;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.cloud.stream.messaging.Source;
//
//@EnableBinding(Sink.class)
//public class MessageProducer {
//
//
//    @StreamListener(Sink.INPUT)
//    public void receive(Object payload) {
//        System.out.println(123);
//    }
//
//}