package com.itheima.config;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ExceptionAdvice {
    @Pointcut("execution(* com.itheima.controller.*Controller.*(..))")
    void pt1() {
    }

    @Around("pt1()")
    Object BusinessException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object proceed = pjp.proceed();
            return proceed;
        } catch (Exception ex) {
            throw new BusinessException("业务异常!");
        }
    }

    @Pointcut("execution(* com.itheima.dao.*Mapper.*(..))")
    void pt2() {
    }

    @Around("pt2()")
    Object SystemException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object proceed = pjp.proceed();
            return proceed;
        } catch (Exception ex) {
            throw new SystemException("系统异常");
        }
    }

    @Pointcut("execution(* com.itheima.entity.*.*(..))")
    void pt3() {
    }

    @Around("pt3()")
    Object OtherException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object proceed = pjp.proceed();
            return proceed;
        } catch (Exception e) {
            throw new Exception("其他异常");
        }
    }
}
