package com.example.domain;

import com.example.enums.UserSexEnum;

/**
 * @author: Yinpeng.Lin
 * @desc: 用于MyBatis注解示例
 * @date: Created in 2018/8/29 15:03
 */
public class Student {
    private Long id;
    private String userName;
    private UserSexEnum userSex;

    /**
     * 默认构造函数必须保留，MyBatis将结果映射成对象时会用到
     */
    public Student() {
    }

    public Student(String userName, UserSexEnum userSex) {
        this.userName = userName;
        this.userSex = userSex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }
}
