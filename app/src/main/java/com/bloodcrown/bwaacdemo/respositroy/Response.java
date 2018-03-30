package com.bloodcrown.bwaacdemo.respositroy;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/3/28 下午12:39
 * 描述 ：
 */

public class Response<T extends Object> {

    public static final int CODE_LOADING = 0;
    public static final int CODE_SUCCESS = 1;

    public int code;
    public String message;
    public T data;

    public Response() {
    }

    public Response(int code, T data) {
        this.code = code;
        this.data = data;
    }
}
