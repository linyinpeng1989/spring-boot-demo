package com.example.demo.common.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by linyp on 2017/8/9.
 */
//@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String content) {
        System.out.println("Receiver 2 : " + content);
    }

}
