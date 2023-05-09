package com.itheima.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private String msg;

    public BusinessException(String msg) {
        this.msg = msg;
    }
}