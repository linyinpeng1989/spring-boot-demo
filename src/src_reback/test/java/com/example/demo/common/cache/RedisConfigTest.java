//package com.example.demo.common.cache;
//
//import com.example.demo.domain.User;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by linyp on 2017/8/8.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisConfigTest {
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    public void test() throws Exception {
//        redisTemplate.opsForValue().set("aaa", "111");
//        Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));
//    }
//
//    @Test
//    public void testObj() throws InterruptedException {
//        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123");
//        ValueOperations<String, User> operations = redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists = redisTemplate.hasKey("com.neo.f");
//        if (exists) {
//            System.out.println("exists is true");
//        } else {
//            System.out.println("exists is false");
//        }
//        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//    }
//
//    @Test
//    public void testKeyGenerator() {
//
//    }
//
//}