package com.example.demo.common.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by linyp on 2017/8/9.
 */
//@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String content = "hello " + new Date();
        System.out.println("Sender: " + content);
        this.rabbitTemplate.convertAndSend(content);
    }

    public void send(Integer index) {
        String content = "hello " + index + " " + new Date();
        System.out.println("Sender: " + content);
        this.rabbitTemplate.convertAndSend(content);
    }
}
