package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private Object data;
    private String msg;
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer ERROR_CODE = 400;


    public static Result success(String msg) {
        return new Result(SUCCESS_CODE, null, msg);
    }

    public static Result success(Object data, String msg) {
        return new Result(SUCCESS_CODE, data, msg);
    }

    public static Result fail(String msg) {
        return new Result(ERROR_CODE, null, msg);
    }

}
