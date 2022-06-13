package com.rabbitmq.product.runner;

import com.rabbitmq.constant.RabbitMqConstants;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wuyj38634
 * @date 2022/6/12
 */
@Slf4j
@Component
public class MqRunner implements ApplicationRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AtomicInteger i = new AtomicInteger(0);
        ThreadPoolExecutor executor = initThreadPoolExecutor();
        for(int a = 0 ; a < 5; a++) {
            executor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    while (true) {
                        String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
                        String sendTime = sdf.format(new Date());
                        Map<String, Object> map = new HashMap<>();
                        map.put("msgId", msgId);
                        map.put("sendTime", sendTime);
                        int msg = i.getAndAdd(1);
                        map.put("msg", msg);
                        rabbitTemplate.convertAndSend(RabbitMqConstants.RABBITMQ_DIRECT_EXCHANGE,
                                RabbitMqConstants.RABBITMQ_DEMO_DIRECT_ROUTING, map);
                        log.info(Thread.currentThread().getName() + "生产消息成功：" + msg);
                        Thread.sleep(1000);
                    }
                }
            });

        }

    }

    public ThreadPoolExecutor initThreadPoolExecutor(){
        // 核心cpu数
        int cpus = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                cpus,
                cpus,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                new ThreadPoolExecutor.CallerRunsPolicy());

        return threadPool;
    }
}
