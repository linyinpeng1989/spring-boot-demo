package com.example.common.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author: Yinpeng.Lin
 * @desc: Session配置类，包括默认过期时间等
 * @date: Created in 2018/8/23 16:49
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 60 * 24)
public class SessionConfig {
}
