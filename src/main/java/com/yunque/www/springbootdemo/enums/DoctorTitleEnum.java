package com.yunque.www.springbootdemo.enums;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:医生分类和等级
 */
public enum DoctorTitleEnum {

    doctor_type(1, "医生"), nurse_type(3, "护士"), echnician_type(5, "科学");

    private int code;
    private String message;


    DoctorTitleEnum(int code, String message) {
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
