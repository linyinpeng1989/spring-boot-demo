package com.example.config;

import com.example.demo.domain.shiro.SysPermission;
import com.example.demo.domain.shiro.SysRole;
import com.example.demo.domain.shiro.SysUser;
import com.example.demo.jpadao.SysUserRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by linyp on 2017/8/10.
 * 相当于Shiro相关的DAO实现，用于从数据源中获取Shiro需要的验证信息，
 * 并进行用户认证
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserRepository sysUserRepository;

    /**
     * 校验权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        for (SysRole role : sysUser.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for(SysPermission permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 校验认证（登录）状态
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        // 获取用户的输入账号
        String userName = (String) token.getPrincipal();
        Object credentials = token.getCredentials();
        System.out.println(credentials);
        // 通过userName从数据库中查找UserEntity对象
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser sysUser = sysUserRepository.findByUserName(userName);
        if (sysUser == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassWord(),
                ByteSource.Util.bytes(sysUser.getCredentialsSalt()), getName());
        return authenticationInfo;
    }
}
