package com.example.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/27 16:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testBaseQuery() {
        // 全部记录
        List<User> users = userRepository.findAll();
        assertTrue(!CollectionUtils.isEmpty(users));

        // 总数
        long count = userRepository.count();
        assertTrue(count > 0);

        // 分页
        Pageable pageable = PageRequest.of(0, 2);
        Page<User> pageUsers = userRepository.findAll(pageable);
        assertNotNull(pageUsers);

        // 分页 + 排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        pageable = PageRequest.of(0, 2, sort);
        pageUsers = userRepository.findAll(pageable);
        assertNotNull(pageUsers);
    }

    @Test
    public void findByUserName() {
        User user = userRepository.findByUserName("张一一");
        assertNotNull(user);

        // 分页 + 排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 2, sort);
        Page<User> pageUsers = userRepository.findByUserName("张一一", pageable);
        assertNotNull(pageUsers);
    }

    @Test
    public void findByUserNameOrEmail() {
        List<User> users = userRepository.findByUserNameOrEmail("张一一", "22222@qq.com");
        assertTrue(users.size() > 0);
    }

    @Test
    public void findFirstByOrderByNickNameAsc() {
        User user = userRepository.findFirstByOrderByNickNameAsc();
        assertNotNull(user);
    }

    @Test
    public void findFirstByOrderByNickNameDesc() {
        User user = userRepository.findFirstByOrderByNickNameDesc();
        assertNotNull(user);
    }

    @Test
    public void findTopByOrderByNickNameDesc() {
        User user = userRepository.findTopByOrderByNickNameDesc();
        assertNotNull(user);
    }

    @Test
    public void findFirst10ByNickName() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<User> users = userRepository.findFirst10ByNickName("一一", sort);
        assertTrue(!CollectionUtils.isEmpty(users));
    }

    @Test
    public void queryFirst10ByNickName() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<User> user = userRepository.queryFirst10ByNickName("一一", pageable);
        assertNotNull(user);
    }

    @Test
    public void findTop10ByNickName() {
        Pageable pageable = PageRequest.of(0, 2);
        List<User> users = userRepository.findTop10ByNickName("一一", pageable);
        assertNotNull(users);
    }

    @Test
    public void modifyNickNameById() {
        int count = userRepository.modifyNickNameById("一二", 1L);
        assertTrue(count > 0);
    }

    @Test
    public void deleteByUserId() {
        userRepository.deleteByUserId(1L);
    }

    @Test
    public void findByEmail() {
        User user = userRepository.findByEmail("22222@qq.com");
        assertNotNull(user);
    }

}