package com.example.common;

import com.example.domain.Message;
import com.example.domain.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/23 19:09
 */
@Configuration
public class MessageConvert {
    @Autowired
    private MessageRepository messageRepository;

    @Bean
    public Converter<String, Message> messageConverter() {
        return new Converter<String, Message>() {
            @Override
            public Message convert(String id) {
                return messageRepository.findMessage(Long.valueOf(id));
            }
        };
    }
}
