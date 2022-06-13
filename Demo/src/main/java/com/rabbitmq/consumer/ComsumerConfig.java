package com.rabbitmq.consumer;

import com.rabbitmq.constant.RabbitMqConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wuyj38634
 * @date 2022/6/12
 */
@Component
@RabbitListener(queues = RabbitMqConstants.RABBITMQ_DEMO_TOPIC)
public class ComsumerConfig {

    @RabbitHandler
    public void process(Map map){
        System.out.println("消费者消费的消息：" + map.toString());
    }
}
