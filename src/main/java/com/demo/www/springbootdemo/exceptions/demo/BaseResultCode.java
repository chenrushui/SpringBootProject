package com.demo.www.springbootdemo.exceptions.demo;

/**
 * 响应码定义
 */
public enum BaseResultCode {
    SUCCESS("000000", "请求成功"),
    LOGIN_RESET("000001", "请重新登录"),
    SYSTEM_ERROR("000002", "系统异常，请重新尝试");

    private String code;
    private String message;

    BaseResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
