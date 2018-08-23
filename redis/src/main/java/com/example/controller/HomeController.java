package com.example.controller;

import com.example.domain.User;
import com.example.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/23 15:54
 */
@RestController
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public User user() {
        return userRepository.findByUserName("张一一");
    }

    /**
     * 使用方法级缓存
     * @param userName
     * @return
     */
    @GetMapping("/user/{userName}")
    /**
     * value表示缓存键的前缀，其余部分依赖于keyGenerator Bean的规则生成，默认会带上所有的参数，可以通过key指定需要的参数。
     * 过期时间依赖于cacheManager Bean中设置的默认过期时间（RedisConfig#cacheManager）
     *
     * 测试地址：http://localhost:8080/user/张一一?extParam=abc
     */
    @Cacheable(value = "user-key")
    // @Cacheable(value = "user-key", key = "#userName")
    public User user(@PathVariable("userName") String userName, String extParam) {
        User user = userRepository.findByUserName(userName);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    /**
     * 实现Session共享（SessionConfig），多台服务器若配置相同即可实现共享。
     * Session在Redis中缓存的键为 spring:session:sessions:{sessionId}
     *
     * 在浏览器cookie中保存SESSION属性，值为sessionId的Base64编码结果。请求时根据cookie的SESSION属性进行Base64解码得到sessionId，
     * 再根据sessionId从Redis中获取Session
     */
    @GetMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
