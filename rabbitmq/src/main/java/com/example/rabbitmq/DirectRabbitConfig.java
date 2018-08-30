package com.example.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Yinpeng.Lin
 * @desc: Direct交换器配置
 * @date: Created in 2018/8/30 10:08
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 未指定绑定时routingKey，则队列routingKey与队列名一致，且仅当消息routingKey与队列routingKey保持一致时，消息才能进入该队列
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("objectQueue");
    }
}
