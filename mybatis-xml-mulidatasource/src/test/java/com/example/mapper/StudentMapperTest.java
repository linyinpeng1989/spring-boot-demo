package com.example.mapper;

import com.example.domain.Student;
import com.example.enums.UserSexEnum;
import com.example.mapper.test1.StudentTest1Mapper;
import com.example.mapper.test2.StudentTest2Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/29 15:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentTest1Mapper studentTest1Mapper;
    @Autowired
    private StudentTest2Mapper studentTest2Mapper;

    @Test
    public void findAll() {
        List<Student> students = studentTest1Mapper.findAll();
        assertTrue(!CollectionUtils.isEmpty(students));

        students = studentTest2Mapper.findAll();
        assertTrue(!CollectionUtils.isEmpty(students));
    }

    @Test
    public void getOne() {
        Student student = studentTest1Mapper.getOne(5L);
        assertNotNull(student);
        student = studentTest2Mapper.getOne(1L);
        assertNotNull(student);
    }

    @Test
    public void insert() {
        studentTest1Mapper.insert(new Student("小刚", UserSexEnum.MAN));
        studentTest1Mapper.insert(new Student("小红", UserSexEnum.WOMAN));
        studentTest2Mapper.insert(new Student("小四", UserSexEnum.MAN));
        studentTest2Mapper.insert(new Student("小美", UserSexEnum.WOMAN));
    }
}