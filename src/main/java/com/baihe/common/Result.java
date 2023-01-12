package com.baihe.common;

public class Result<T> {
    private String code;
    private String msg;
    private T data;

    private String username;
    private Result(T data) {
        this.data = data;
    }

    public Result() {
    }

    public static Result success() {
        Result tResult = new Result<>();
        tResult.setCode(ResultCode.SUCCESS.code);
        tResult.setMsg(ResultCode.SUCCESS.msg);
        return tResult;
    }

    public static <T> Result<T> success(T data) {
        Result<T> tResult = new Result<>(data);
        tResult.setCode(ResultCode.SUCCESS.code);
        tResult.setMsg(ResultCode.SUCCESS.msg);
        return tResult;
    }

    public static <T> Result<T> success(T data,String username) {
        Result<T> tResult = new Result<>(data);
        tResult.setCode(ResultCode.SUCCESS.code);
        tResult.setMsg(ResultCode.SUCCESS.msg);
        tResult.setUsername(username);
        return tResult;
    }

    public static Result error() {
        Result tResult = new Result<>();
        tResult.setCode(ResultCode.ERROR.code);
        tResult.setMsg(ResultCode.ERROR.msg);
        return tResult;
    }

    public static Result error(String code, String msg) {
        Result tResult = new Result<>();
        tResult.setCode(code);
        tResult.setMsg(msg);
        return tResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
