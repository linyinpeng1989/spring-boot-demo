package com.example.datasource;

import com.example.datasource.props.MultipleMongoProperties;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @author: Yinpeng.Lin
 * @desc: MongoDB多数据源配置，声明多个数据源
 * @date: Created in 2018/8/31 10:24
 */
@Configuration
public class MultipleMongoConfig {
    @Autowired
    private MultipleMongoProperties mongoProperties;

    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
    @Primary    // 使用多数据源过程中，必须指定主库
    public MongoTemplate primaryMongoTemplate() {
        MongoTemplate template = new MongoTemplate(this.primaryFactory(mongoProperties.getPrimary()));
        return template;
    }

    @Bean(name = SecondaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate() {
        MongoTemplate template = new MongoTemplate(this.secondaryFactory(mongoProperties.getSecondary()));
        return template;
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties mongoProperties) {
        return new SimpleMongoDbFactory(new MongoClientURI(mongoProperties.getUri()));
    }

    @Bean
    public MongoDbFactory secondaryFactory(MongoProperties mongoProperties) {
        return new SimpleMongoDbFactory(new MongoClientURI(mongoProperties.getUri()));
    }

}
