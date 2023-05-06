package com.itheima.controller;

import com.itheima.entity.Result;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;

@RestControllerAdvice
@Slf4j
// TODO 捕获异常
public class ExceptionHandle implements HandlerInterceptor {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        return Result.fail(e.getMsg());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        return Result.fail(e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public Result OtherException(Exception e) {
        return Result.fail(e.getMessage());
    }
}
