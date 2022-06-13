package com.rabbitmq.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.constant.RabbitMqConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wuyj38634
 * @date 2022/6/12
 */
@Service
@Slf4j
public class RabbitMQServiceImpl implements RabbitMQService {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) {
        try{
            log.info("start mq");
            String msgId= UUID.randomUUID().toString().replace("-", "").substring(0, 32);;
            String sendTime = sdf.format(new Date());
            Map<String, Object> map = new HashMap<>();
            map.put("msgId", msgId);
            map.put("sendTime", sendTime);
            map.put("msg", msg);
            rabbitTemplate.convertAndSend(RabbitMqConstants.RABBITMQ_DIRECT_EXCHANGE,
                    RabbitMqConstants.RABBITMQ_DEMO_DIRECT_ROUTING, map);
            return "ok";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
