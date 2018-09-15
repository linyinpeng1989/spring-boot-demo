package com.example.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/9/10 11:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaSenderTest {

    @Autowired
    private KafkaSender kafkaSender;

    @Test
    public void send() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            kafkaSender.send();
            Thread.sleep(100);
        }
    }


    @Test
    public void sendJson() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            kafkaSender.sendJson();
            Thread.sleep(100);
        }
    }
}