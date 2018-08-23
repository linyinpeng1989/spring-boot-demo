package com.example.demo.jpadao;

import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by linyp on 2017/8/8.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName, String email);

    Page<User> findByUserNameIn(List<String> userNames, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update User u set u.nickName=?3 where u.id=?1 and u.userName=?2")
    int modifyByIdAndUserName(Long id, String userName, String nickName);

    @Query("select u from User u where u.email=?1")
    User findByEmailAddress(String email);
}
