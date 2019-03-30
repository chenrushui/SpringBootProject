package com.yunque.www.springbootdemo.exceptions;

/**
 * Created on 2019/3/17.
 * author:crs
 * Description:常见错误类型
 */

//@Data,只支持类，不支持枚举类型
public enum PicaResultCode {

    INTERFACE_INVOKE_EXCEPTION("500005", "接口调用时内部存在异常");

    private String code;
    private String message;

    PicaResultCode(String code, String message) {
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
