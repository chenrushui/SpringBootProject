package com.yunque.www.springbootdemo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DoctorPrivacySettings implements Serializable {
    private Long id;

    private Long doctorId;

    private Integer privacyType;

    private Integer deleteFlag;

    private Long createdId;

    private Date createdTime;

    private Long modifiedId;

    private Date modifiedTime;
}