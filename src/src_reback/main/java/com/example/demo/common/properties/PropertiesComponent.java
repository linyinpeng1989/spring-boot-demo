package com.example.demo.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by linyp on 2017/8/8.
 * 自定义配置文件
 */
@Component
public class PropertiesComponent {
    @Value("${com.example.demo.title}")
    public String title;
    @Value("${com.example.demo.desc}")
    public String desc;
}
