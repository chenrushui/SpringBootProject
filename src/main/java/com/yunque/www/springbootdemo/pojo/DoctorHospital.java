package com.yunque.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DoctorHospital {
    private Long id;

    private Long doctorId;

    private Long hospitalId;

    private Integer status;

    private Integer sysCode;

    private String memo;

    private Integer deleteFlag;

    private Long createdId;

    private Date createdTime;

    private Long modifiedId;

    private Date modifiedTime;


}