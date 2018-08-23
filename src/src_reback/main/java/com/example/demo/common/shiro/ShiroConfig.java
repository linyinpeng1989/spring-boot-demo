package com.example.demo.common.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by linyp on 2017/8/10.
 * Shiro配置
 *
 Filter Name	Class
 anon	        org.apache.shiro.web.filter.authc.AnonymousFilter
 authc	        org.apache.shiro.web.filter.authc.FormAuthenticationFilter
 authcBasic	    org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter
 perms	        org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter
 port	        org.apache.shiro.web.filter.authz.PortFilter
 rest	        org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter
 roles	        org.apache.shiro.web.filter.authz.RolesAuthorizationFilter
 ssl	        org.apache.shiro.web.filter.authz.SslFilter
 user	        org.apache.shiro.web.filter.authc.UserFilter

 anon：所有url都都可以匿名访问
 authc：需要认证才能进行访问
 user：配置记住我或认证通过可以访问
 */
@Configuration
public class ShiroConfig {

    /**
     * 声明Shiro过滤器工厂类，实现过滤、权限校验等
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接(anon:所有url都可以匿名访问)
        filterChainDefinitionMap.put("/static/**", "anon");
        // 配置退出过滤器,其中具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        // 配置需要认证的链接（authc:所有url都必须认证通过才可以访问）
        filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 声明SecurityManager对象
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }
}
