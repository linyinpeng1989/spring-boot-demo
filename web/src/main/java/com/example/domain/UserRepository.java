package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Yinpeng.Lin
 * @desc: User实体对应的Repository
 * @date: Created in 2018/8/23 13:48
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据姓名查找用户
     *
     * @param userName 姓名
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据姓名或邮箱查找用户
     *
     * @param userName 姓名
     * @param email    邮箱
     * @return
     */
    List<User> findByUserNameOrEmail(String userName, String email);
}
