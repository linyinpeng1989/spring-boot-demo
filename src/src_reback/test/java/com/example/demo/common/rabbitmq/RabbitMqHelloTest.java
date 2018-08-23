package com.example.demo.common.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by linyp on 2017/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {
    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() {
        helloSender.send();
    }

    @Test
    public void oneToMany() {
        for (int index = 0; index < 100; index++) {
            helloSender.send(index);
        }
    }
}
