package com.yunque.www.springbootdemo.exceptions;

public class SystemException extends Exception{
    private String message;
    private String code;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
