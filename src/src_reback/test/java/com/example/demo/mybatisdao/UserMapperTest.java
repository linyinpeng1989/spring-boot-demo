package com.example.demo.mybatisdao;

import com.example.demo.domain.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by linyp on 2017/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() throws Exception {
        List<UserDO> result = userMapper.getAll();
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void insert() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        //
        //userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        UserDO userDO = new UserDO();
        userDO.setUserName("dd4");
        userDO.setNickName("dd4321");
        userDO.setRegTime(formattedDate);
        userDO.setEmail("dd4@ee.com");
        userDO.setPassWord("dd4444");
        userMapper.insert(userDO);
    }

}