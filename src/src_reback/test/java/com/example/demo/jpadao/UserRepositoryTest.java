package com.example.demo.jpadao;

import com.example.demo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by linyp on 2017/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserName() throws Exception {
    }

    @Test
    public void findByUserNameOrEmail() throws Exception {

    }

    @Test
    public void test() {
        //Date date = new Date();
        //DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        //String formattedDate = dateFormat.format(date);
        //
        //userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        //userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
        //userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));
        //
        //Assert.assertEquals(3, userRepository.findAll().size());
        //Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("cc3", "cc@126.com").getNickName());
        //userRepository.delete(userRepository.findByUserName("aa1"));
        Pageable pageable = new PageRequest(1, 1);
        Page<User> pageResult = userRepository.findByUserNameIn(Arrays.asList("bb2", "cc3"), pageable);
        Assert.assertEquals(1, pageResult.getNumber());

        userRepository.modifyByIdAndUserName(2L, "bb2", "bb54321");
        Assert.assertEquals("cc3", userRepository.findByEmailAddress("cc@126.com").getUserName());
    }

}