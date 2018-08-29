package com.example.mapper;

import com.example.domain.Student;
import com.example.enums.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/29 15:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void findAll() {
        List<Student> students = studentMapper.findAll();
        assertTrue(!CollectionUtils.isEmpty(students));
    }

    @Test
    public void getOne() {
        Student student = studentMapper.getOne(1L);
        assertNotNull(student);
    }

    @Test
    public void insert() {
        studentMapper.insert(new Student("小刚", UserSexEnum.MAN));
        studentMapper.insert(new Student("小红", UserSexEnum.WOMAN));
        studentMapper.insert(new Student("小四", UserSexEnum.MAN));
        studentMapper.insert(new Student("小美", UserSexEnum.WOMAN));
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(1L);
        student.setUserName("小刚刚");
        studentMapper.update(student);
    }

    @Test
    public void delete() {
        studentMapper.delete(1L);
    }
}