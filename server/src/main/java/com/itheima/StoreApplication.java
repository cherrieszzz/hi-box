package com.itheima;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Slf4j
public class StoreApplication implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，
        registry.addInterceptor(new SaInterceptor(handle -> {
                    log.info("当前用户角色集合:" + StpUtil.getRoleList());
                    log.info("当前用户权限集合:" + StpUtil.getPermissionList());
                }))
                .addPathPatterns("/**");
    }


    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

}
