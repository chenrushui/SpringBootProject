package com.demo.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DoctorAgreement {
    private Long id;

    private Integer agreementType;

    private String version;

    private Integer deleteFlag;

    private Long createdId;

    private Date createdTime;

    private Long modifiedId;

    private Date modifiedTime;

    private String agreementContent;

}