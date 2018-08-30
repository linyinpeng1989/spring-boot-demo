package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Yinpeng.Lin
 * @desc: 接收者
 * @date: Created in 2018/8/30 10:08
 */
@Component
@RabbitListener(queues = {"helloQueue", "objectQueue", "topic.message1", "fanout.A", "fanout.B", "fanout.C"})  // 指定消费哪些队列
public class HelloReceiver {

    @RabbitHandler
    public void process(String content) {
        System.out.println("Receiver 1 : " + content);
    }

}
