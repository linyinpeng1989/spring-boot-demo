package com.example.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/9/10 10:36
 */
@Data
public class Message {
    private Long id;

    private String msg;

    private Date sendTime;
}
