package com.example.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author: Yinpeng.Lin
 * @desc: 第二个MongoDB配置，template为primaryMongoTemplate
 * @date: Created in 2018/8/31 10:15
 */
// 指定第二数据源的template（Bean在MultipleMongoConfig中声明）及其对应的repository处理目录
@Configuration
@EnableMongoRepositories(basePackages = "com.example.domain.secondary",
        mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {
    /**
     * 设置第二个template的BeanName常量
     */
    public static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}
