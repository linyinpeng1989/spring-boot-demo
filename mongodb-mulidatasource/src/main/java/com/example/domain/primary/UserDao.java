package com.example.domain.primary;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/30 18:53
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
