package com.example.common;

import com.example.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/23 15:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("test_aaa", "111");
        redisTemplate.expire("test_aaa", 1, TimeUnit.MINUTES);
        Assert.assertNotNull(redisTemplate.opsForValue().get("test_aaa"));
    }

    @Test
    public void testObj() throws InterruptedException {
        User user = new User("张一一", "11111", "11111@qq.com", "一一", "2018年8月23日 下午02时48分14秒");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("com.neox", user, 10, TimeUnit.SECONDS);
        valueOperations.set("com.neo.f", user,1,TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.neo.f");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }

}