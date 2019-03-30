package com.yunque.www.springbootdemo.enums;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:用户协议类型
 */
public enum AgreementTypeEnum {

    //TODO:枚举中是常量，需要全部是大写

    USER_AGREEMENT(1,"用户协议"), PRIVATE_AGREEMENT(5,"隐私协议");

    private int code;
    private String message;


    AgreementTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
