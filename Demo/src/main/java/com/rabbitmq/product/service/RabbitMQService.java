package com.rabbitmq.product.service;

/**
 * @author wuyj38634
 * @date 2022/6/12
 */
public interface RabbitMQService {

    /**
     * 发送mq
     * @param msg
     * @return
     */
    String sendMsg(String msg);
}
