package com.example.domain;

import com.example.domain.primary.UserDao;
import com.example.domain.primary.UserEntity;
import com.example.domain.secondary.Student;
import com.example.domain.secondary.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/30 18:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleMongoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSave() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(4L);
        user.setUserName("小红");
        user.setPassword("fffooo123");
        userDao.saveUser(user);

        Student student = new Student();
        student.setId(1L);
        student.setName("小红");
        studentDao.saveStudent(student);
    }

    @Test
    public void findByUserName() {
        UserEntity user = userDao.findUserByUserName("小明");
        System.out.println("user is " + user);

        Student student = studentDao.findStudentByName("小红");
        System.out.println("student is " + student);
    }

    @Test
    public void update() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUserName("天空");
        user.setPassword("fffxxxx");
        userDao.updateUser(user);

        Student student = new Student();
        student.setId(1L);
        student.setName("小刚");
        studentDao.updateStudent(student);
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(1L);

        studentDao.deleteStudentById(1L);
    }

}