package com.example.domain;

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
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/23 13:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        // 2018年8月23日 下午01时59分11秒
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formatStr = dateFormat.format(new Date());

        userRepository.save(new User("张一一", "11111", "11111@qq.com", "一一", formatStr));
        userRepository.save(new User("张二二", "22222", "22222@qq.com", "二二", formatStr));
        userRepository.save(new User("张三三", "33333", "33333@qq.com", "三三", formatStr));
        userRepository.save(new User("张四四", "44444", "44444@qq.com", "四四", formatStr));
    }

    @Test
    public void findByUserName() {
        User user = userRepository.findByUserName("张一一");
        Assert.assertNotNull(user);
    }

    @Test
    public void findByUserNameOrEmail() {
        List<User> users = userRepository.findByUserNameOrEmail("张一一", "22222@qq.com");
        Assert.assertTrue(users.size() > 0);
    }
}