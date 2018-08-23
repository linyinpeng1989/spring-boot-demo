package com.example.demo.jpadao;

import com.example.demo.domain.shiro.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by linyp on 2017/8/11.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUserName(String userName);
}
