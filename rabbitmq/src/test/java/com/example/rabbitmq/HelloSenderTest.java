package com.example.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/30 10:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSenderTest {
    @Autowired
    private HelloSender helloSender;

    @Test
    public void send() {
        helloSender.send();
    }

    @Test
    public void send1() {
        for (int index = 0; index < 100; index++) {
            helloSender.send(index);
        }
    }

    @Test
    public void sendObject() {
        for (int index = 0; index < 100; index++) {
            HelloSender.User user = new HelloSender.User("小明"+index, "男", index+"");
            helloSender.sendObject(user);
        }
    }

    @Test
    public void sendTopic1() {
        helloSender.sendTopic1();
    }

    @Test
    public void sendTopic2() {
        helloSender.sendTopic2();
    }

    @Test
    public void sendFanout() {
        for (int index = 0; index < 100; index++) {
            helloSender.sendFanout();
        }
    }

}