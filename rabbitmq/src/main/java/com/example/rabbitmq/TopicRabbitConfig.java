package com.example.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Yinpeng.Lin
 * @desc: Topic交换器配置
 * @date: Created in 2018/8/30 10:08
 */
@Configuration
public class TopicRabbitConfig {
    final static String message1 = "topic.message1";
    final static String message2 = "topic.message2";

    @Bean
    public Queue queueMessage1() {
        return new Queue(message1);
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue(message2);
    }

    /**
     * 声明主题交换器，名称为exchange
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 将队列绑定到交换器，并指定routingKey
     *
     * @param queueMessage1 队列
     * @param exchange      交换器
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage1, TopicExchange exchange) {
        // 消息routingKey与队列绑定时指定的routingKey需要匹配，即指定了routingKey时，与队列名无关
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message");
    }

    /**
     * 将队列绑定到交换器，并指定routingKey
     *
     * @param queueMessage2 队列
     * @param exchange      交换器
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessage2, TopicExchange exchange) {
        // 消息routingKey与队列绑定时指定的routingKey需要匹配，即指定了routingKey时，与队列名无关
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.#");
    }
}
