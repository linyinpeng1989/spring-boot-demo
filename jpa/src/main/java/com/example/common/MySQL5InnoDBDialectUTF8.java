package com.example.common;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @author: Yinpeng.Lin
 * @desc: spring-data-jpa自动建表指定编码
 * @date: Created in 2018/8/23 14:45
 */
public class MySQL5InnoDBDialectUTF8 extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
