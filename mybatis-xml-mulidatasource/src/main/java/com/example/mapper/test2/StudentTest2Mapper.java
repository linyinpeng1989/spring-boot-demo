package com.example.mapper.test2;

import com.example.domain.Student;

import java.util.List;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/29 15:03
 */
public interface StudentTest2Mapper {

    List<Student> findAll();

    Student getOne(Long id);

    void insert(Student student);

    void update(Student student);

    void delete(Long id);
}
