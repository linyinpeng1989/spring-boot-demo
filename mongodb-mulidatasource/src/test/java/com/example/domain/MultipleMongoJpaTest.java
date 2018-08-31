package com.example.domain;

import com.example.domain.primary.UserEntity;
import com.example.domain.primary.UserRepository;
import com.example.domain.secondary.Student;
import com.example.domain.secondary.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/31 13:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleMongoJpaTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testSave() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(5L);
        user.setUserName("小红");
        user.setPassword("fffooo123");
        userRepository.save(user);

        Student student = new Student();
        student.setId(2L);
        student.setName("小红");
        studentRepository.save(student);
    }

    @Test
    public void findByUserName() {
        UserEntity user = userRepository.findByUserName("小明");
        System.out.println("user is " + user);

        Student student = studentRepository.findByName("小红");
        System.out.println("student is " + student);
    }

    @Test
    public void update() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUserName("天空");
        user.setPassword("fffxxxx");
        userRepository.save(user);

        Student student = new Student();
        student.setId(1L);
        student.setName("小刚");
        studentRepository.save(student);
    }

    @Test
    public void deleteUserById() {
        userRepository.deleteById(1L);

        studentRepository.deleteById(1L);
    }

}
