package com.example.demo.common.mongo;

import com.example.demo.domain.UserEntity;

/**
 * Created by linyp on 2017/8/10.
 */
public interface UserDao {
    /**
     * 新增用户
     * @param userEntity
     */
    void saveUser(UserEntity userEntity);

    /**
     * 根据姓名查找用户
     * @param userName
     * @return
     */
    UserEntity findUserByUserName(String userName);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(UserEntity user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUserById(Long id);
}
