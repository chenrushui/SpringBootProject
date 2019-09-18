package com.yunque.www.springbootdemo.exceptions.demo;


/**
 * 异常信息结构定义,异常码,异常信息
 */
public class BaseException extends RuntimeException {
    private String code;
    private String msg;

    public BaseException() {
    }

    //只传递异常码进来
    public BaseException(String code) {
        this.code = code;
    }

    //传递异常信息进来
    public BaseException(String code, String msg) {
        this(code, msg, (Throwable) null);
    }

    public BaseException(String code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }


    //传递枚举类型的异常信息进来
    public BaseException(BaseResultCode baseResultCode) {
        this(baseResultCode, (Throwable) null);
    }

    public BaseException(BaseResultCode baseResultCode, Throwable cause) {
        super(cause);
        this.code = baseResultCode.getCode();
        this.msg = baseResultCode.getMessage();
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
}
