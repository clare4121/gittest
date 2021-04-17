package com.cyp.gitnewmodulewhole.util.util.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaoxuan
 * @description TODO
 * @createTime 2020/6/3 7:43 下午
 */
@Data
@AllArgsConstructor
public class Result {

    private Integer code;

    private String msg;

    private Object data;

    public static Result ok() {
        return new Result(200, "success", null);
    }

    public static Result ok(Object data) {
        return new Result(200, "success", data);
    }

    public static Result error(String msg) {
        return new Result(500, msg, null);
    }

    public static Result error() {
        return new Result(500, null, null);
    }



}
