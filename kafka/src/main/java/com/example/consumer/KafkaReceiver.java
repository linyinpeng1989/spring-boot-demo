package com.example.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: Yinpeng.Lin
 * @desc: 消息接收者，消费者
 * @date: Created in 2018/9/10 10:37
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"testTopic"})
    public void listen(ConsumerRecord<String, String> record) {
        Optional<String> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------------- record = {}", record);
            log.info("----------------------- message = {}", message);
        }
    }
}
