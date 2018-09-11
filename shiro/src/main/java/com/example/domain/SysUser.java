package com.example.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by linyp on 2017/8/10.
 */
@Entity
public class SysUser {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String userName;                    // 账号
    private String name;                        // 名称
    private String passWord;                    // 密码
    private String salt;                        // 加密密码的盐
    private byte state;                         // 用户状态：0-创建未认证，1-正常状态，2-用户被锁定
    @ManyToMany(fetch = FetchType.EAGER)        // 立即从数据库中加载数据
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList; // 用户可以拥有多个角色（根据uid从用户角色关系表获取角色列表, sys_user_role）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public String getCredentialsSalt() {
        return userName + salt;
    }
}
