package com.itheima.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageInterceptor {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//创建拦截器对象
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//添加分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
//返回拦截器
        return interceptor;
    }
}
