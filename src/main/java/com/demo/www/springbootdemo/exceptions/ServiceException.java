package com.demo.www.springbootdemo.exceptions;

public class ServiceException extends Exception {

    private String message;
    private String code;

    @Override
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
