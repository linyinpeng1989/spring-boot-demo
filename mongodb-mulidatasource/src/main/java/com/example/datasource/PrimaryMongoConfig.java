package com.example.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author: Yinpeng.Lin
 * @desc: 第一个MongoDB配置，template为primaryMongoTemplate
 * @date: Created in 2018/8/31 10:15
 */
// 指定主数据源的template（Bean在MultipleMongoConfig中声明）及其对应的repository处理目录
@Configuration
@EnableMongoRepositories(basePackages = "com.example.domain.primary",
        mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {
    /**
     * 设置第一个template的BeanName常量
     */
    public static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}
