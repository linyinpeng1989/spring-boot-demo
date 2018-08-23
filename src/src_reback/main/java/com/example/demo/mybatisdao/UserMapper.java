package com.example.demo.mybatisdao;

import com.example.demo.domain.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by linyp on 2017/8/8.
 */
public interface UserMapper {
    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id", javaType = Long.class),
            @Result(property = "userName", column = "user_name", javaType = String.class),
            @Result(property = "passWord", column = "pass_word", javaType = String.class),
            @Result(property = "email", column = "email", javaType = String.class),
            @Result(property = "nickName", column = "nick_name", javaType = String.class),
            @Result(property = "regTime", column = "reg_time", javaType = String.class)
    })
    List<UserDO> getAll();

    @Insert("INSERT INTO user(user_name,pass_word,email,nick_name,reg_time) VALUES(#{userName}, #{passWord}, #{email}, #{nickName}, #{regTime})")
    void insert(UserDO user);
}
