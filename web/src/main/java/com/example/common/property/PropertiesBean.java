package com.example.common.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Yinpeng.Lin
 * @desc: 自定义Property(配置文件)
 * @date: Created in 2018/8/23 13:11
 */
@Component
public class PropertiesBean {
    @Value("${com.title}")
    private String title;
    @Value("${com.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
