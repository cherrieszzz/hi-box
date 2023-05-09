package com.itheima.exception;

import lombok.Data;

@Data
public class SystemException extends RuntimeException {
    private String msg;

    public SystemException(String msg) {
        this.msg = msg;
    }
}