package com.baihe.common;

public enum ResultCode {
    SUCCESS("0", "成功"),
    SCHEDULE_EXIST("2008","此月未设置日程"),
    SCHEDULE_MESSAGE_EXIST("2009","此日期未设置日程"),
    ERROR("-1", "系统异常"),
    PARAM_ERROR("1001", "参数异常"),
    USER_EXIST_ERROR("2001", "用户已存在"),


    USER_ACCOUNT_ERROR("2002", "账号或密码错误"),
    USER_NOT_EXIST_ERROR("2003", "未找到用户"),
    PARAM_LOST_ERROR("2004", "参数缺失"),
    PARAM_PASSWORD_ERROR("2005", "原密码输入错误"),
    PARAM_PASSWORD_UPDATE_ERROR("2006", "不可与原密码相同"),
    ;

    public String code;
    public String msg;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }
    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
