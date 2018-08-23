package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.jpadao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by linyp on 2017/8/8.
 */
@RestController
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    /*@GetMapping("/getUser")
    public SimpleUser getUser() {
        SimpleUser simpleUser = new SimpleUser();
        simpleUser.setUserNmae("小明");
        simpleUser.setPassWord("XXXXX");
        return simpleUser;
    }*/

    /**
     * 按照键值“user-key”缓存
     * @return
     */
    @GetMapping("/getUser")
    @Cacheable(value = "user-key")  //自动根据方法生成缓存
    public User getUser() {
        User user = userRepository.findByUserName("aa");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    /**
     * SpringBoot Session共享
     * @param session
     * @return
     */
    @GetMapping("/getUuid")
    public String getUuid(HttpSession session) {
        UUID uuid = (UUID) session.getAttribute("uid");
        if (uuid == null) {
            uuid =UUID.randomUUID();
        }
        session.setAttribute("uid", uuid);
        return session.getId();
    }

    /**
     * 添加用户
     * 使用@Valid注解 及 对象上注解（如@Length、@Min等）进行校验，校验结果会写入到BindingResult中
     * @param user
     * @return
     */
    @PostMapping("add")
    public User addUser(@Valid User user, BindingResult bindingResult) {
        // 判断校验表单（字段）校验是否通过
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return userRepository.save(user);
    }

}
