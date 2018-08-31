package com.example.domain.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/31 13:05
 */
public interface UserRepository extends MongoRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
}
