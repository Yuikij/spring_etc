package com.spring.test.activeMQ;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

@Log4j2
public class Test {

    public static void main(String[] args) {


        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://106.14.105.145:41616");
        //
        try {
            Connection createConnection = connectionFactory.createConnection("client", "d63a6557aa5fe703cefc5cc50f846895");
            createConnection.start();
            Session session = createConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            String queueName = "Consumer." + "test" + ".VirtualTopic.T-SUBS-" + "206251";
            Queue queue = new ActiveMQQueue(queueName);
            MessageConsumer messageConsumer = session.createConsumer(queue);
            messageConsumer.setMessageListener(message -> {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    String body = textMessage.getText();
                    log.info("开始解析队列信息");
//                    System.out.println("开始解析队列信息");
//                    System.out.println(body);
                    log.info(body);
//                    SubReceiveResp subLocationResp = JSONObject.parseObject(body, SubReceiveResp.class);
//                    if (subLocationResp.getType().equals(SubscribeConstants.LOCATION)) {
//                        LocationDataResp locationDataResp = JSONObject.parseObject(
//                                JSONObject.toJSONString(subLocationResp.getData()), LocationDataResp.class);
//                        //处理定位数据
//                        locationHandle.handle(locationDataResp);
//                    }
                    //...处理其他类型订阅数据         
                } catch (JMSException e) {
                    e.printStackTrace();
                    log.error("解析消息队列信息报错" + e);
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
            log.error("创建消息队列报错" + e);
        }
    }
}
