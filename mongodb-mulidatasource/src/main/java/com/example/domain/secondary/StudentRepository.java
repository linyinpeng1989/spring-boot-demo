package com.example.domain.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: Yinpeng.Lin
 * @desc: MongoDB JPA操作
 * @date: Created in 2018/8/31 13:04
 */
public interface StudentRepository extends MongoRepository<Student, Long> {

    Student findByName(String name);
}
