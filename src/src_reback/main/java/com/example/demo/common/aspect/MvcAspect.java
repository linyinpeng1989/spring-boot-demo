package com.example.demo.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by linyp on 2017/8/19.
 * AOP使用
 */
@Aspect
@Component
public class MvcAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Before("execution(public * com.example.demo..*.*(..))")
    //public void logBefore() {
    //    System.out.println("logBefore");
    //}
    //
    //@After("execution(public * com.example.demo..*.*(..))")
    //public void logAfter() {
    //    System.out.println("logAfter");
    //}

    // 定义一个切点，可多次使用
    @Pointcut("execution(public * com.example.demo..*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //System.out.println("logBefore");
        logger.info("logBefore");

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] infoStr = joinPoint.getArgs();
    }

    @After("log()")
    public void doAfter() {
        //System.out.println("doAfter");
        logger.info("doAfter");
    }

    @AfterReturning(value = "log()", returning = "object")
    public void doAfterReturn(Object object) {
        logger.info(object.toString());
    }
}
