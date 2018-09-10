package com.example.provider;
import java.util.Date;
import java.util.UUID;

import com.example.domain.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: Yinpeng.Lin
 * @desc: 消息发送者，生产者
 * @date: Created in 2018/9/10 10:37
 */
@Component
@Slf4j  // 内置log对象
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("++++++++++++++++++++++++++++++++++ message = {}", gson.toJson(message));

        kafkaTemplate.send("testTopic", gson.toJson(message));
    }

}
