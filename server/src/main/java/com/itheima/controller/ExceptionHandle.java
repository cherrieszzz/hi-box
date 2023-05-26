package com.itheima.controller;

import cn.dev33.satoken.exception.SaTokenException;
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
    @ExceptionHandler(SaTokenException.class)
    public Result handlerSaTokenException(SaTokenException e) {

        // 根据不同异常细分状态码返回不同的提示
        if (e.getCode() == 30001) {
            return Result.fail("redirect 重定向 url 是一个无效地址");
        }
        if (e.getCode() == 30002) {
            return Result.fail("redirect 重定向 url 不在 allowUrl 允许的范围内");
        }
        if (e.getCode() == 30004) {
            return Result.fail("提供的 ticket 是无效的");
        }
        if (e.getCode() == 11011) {
            return Result.fail("未能读取到有效Token");
        }
        if (e.getCode() == 11012) {
            return Result.fail("Token无效");
        }
        if (e.getCode() == 11013) {
            return Result.fail("Token已过期");
        }
        if (e.getCode() == 11014) {
            return Result.fail("Token已被顶下线");
        }
        if (e.getCode() == 11016) {
            return Result.fail("Token已临时过期");
        }
        if (e.getCode() == 11041) {
            return Result.fail("缺少指定的角色");
        }
        if (e.getCode() == 11051) {
            return Result.fail("缺少指定的权限");
        }
        if (e.getCode() == 11012) {
            return Result.fail("Token无效");
        }

        // 更多 code 码判断 ...

        // 默认的提示
        return Result.fail("服务器繁忙，请稍后重试...");
    }

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
