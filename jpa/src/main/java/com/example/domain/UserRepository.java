package com.example.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
     * 根据姓名查找，结果分页
     *
     * @param userName 姓名
     * @param pageable 分页参数，一般作为最后一个参数
     * @return
     */
    Page<User> findByUserName(String userName, Pageable pageable);

    /**
     * 根据姓名或邮箱查找用户
     *
     * @param userName 姓名
     * @param email    邮箱
     * @return
     */
    List<User> findByUserNameOrEmail(String userName, String email);

    /**
     * 获取字段升序排序后的第一条数据
     * @return
     */
    User findFirstByOrderByNickNameAsc();

    /**
     * 获取字段降序排序后的第一条数据
     * @return
     */
    User findFirstByOrderByNickNameDesc();

    /**
     * 获取字段降序排序后第一条数据
     * @return
     */
    User findTopByOrderByNickNameDesc();

    /**
     * 获取前10条数据，结果分页
     * @param nickName
     * @param pageable
     * @return
     */
    Page<User> queryFirst10ByNickName(String nickName, Pageable pageable);

    /**
     * 获取前10条数据（排序后）
     * @param nickName
     * @param sort
     * @return
     */
    List<User> findFirst10ByNickName(String nickName, Sort sort);

    /**
     * 获取前10条数据，结果分页
     * @param nickName
     * @param pageable
     * @return
     */
    List<User> findTop10ByNickName(String nickName, Pageable pageable);

    /**
     * 根据ID修改昵称
     * @param nickName
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update User u set u.nickName = ?1 where u.id = ?2")
    int modifyNickNameById(String nickName, Long id);

    /**
     * 根据ID删除用户，事务控制
     * @param id
     */
    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteByUserId(Long id);

    /**
     * 根据邮件地址查询，超时事务控制
     * @param email
     * @return
     */
    @Transactional(timeout = 10)
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
