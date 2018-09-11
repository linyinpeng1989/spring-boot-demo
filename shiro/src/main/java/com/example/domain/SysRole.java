package com.example.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by linyp on 2017/8/10.
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Integer id;
    private String role;                        // 角色标识(名称)，如"admin",
    private String description;                 // 角色描述
    private Boolean available = Boolean.FALSE;  // 是否可用，如果不可用则不会添加给用户
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;    // 角色可以拥有多个权限（根据roleId从角色权限关系表获取权限列表, sys_role_permission）

    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    private List<SysUser> userInfos;            // 角色可以分配给多个用户（根据roleId从用户角色关系表获取用户列表, sys_user_role）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUser> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<SysUser> userInfos) {
        this.userInfos = userInfos;
    }
}
