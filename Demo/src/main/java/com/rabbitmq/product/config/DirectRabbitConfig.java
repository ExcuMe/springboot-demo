package com.rabbitmq.product.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rabbitmq.constant.RabbitMqConstants;


import org.springframework.amqp.core.Queue;


/**
 * @author wuyj38634
 * @date 2022/6/12
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue rabbitmqDemoDirectQueue(){
        /**
         * 1、name:    队列名称
         * 2、durable: 是否持久化
         * 3、exclusive: 是否独享、排外的。如果设置为true，定义为排他队列。则只有创建者可以使用此队列。也就是private私有的。
         * 4、autoDelete: 是否自动删除。也就是临时队列。当最后一个消费者断开连接后，会自动删除。
         * */
        return new Queue(RabbitMqConstants.RABBITMQ_DEMO_TOPIC, true, false, false);
    }

    /**
     * 交换机
     * @return
     */
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(RabbitMqConstants.RABBITMQ_DIRECT_EXCHANGE, true, false);
    }

    @Bean
    public Binding bindDirect(){
        return BindingBuilder
                //绑定队列
                .bind(rabbitmqDemoDirectQueue())
                // 到交换机
                .to(exchange())
                // 设置匹配键
                .with(RabbitMqConstants.RABBITMQ_DEMO_DIRECT_ROUTING);
    }


}
