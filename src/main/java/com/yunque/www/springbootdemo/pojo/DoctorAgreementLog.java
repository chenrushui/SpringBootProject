package com.yunque.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DoctorAgreementLog {
    private Long id;

    private Long doctorId;

    private Integer agreementType;

    private String version;

    private Integer deleteFlag;

    private Long createdId;

    private Date createdTime;

    private Long modifiedId;

    private Date modifiedTime;

    public DoctorAgreementLog(Long doctorId, Integer agreementType, String version) {
        //todo:id自增，不用考虑
        //this.id = id;
        this.doctorId = doctorId;
        this.agreementType = agreementType;
        this.version = version;
        this.deleteFlag = 1;
        this.createdId = doctorId;
        this.createdTime = new Date();
        this.modifiedId = doctorId;
        this.modifiedTime = new Date();
    }

    public DoctorAgreementLog(Long id, Long doctorId, Integer agreementType, String version, Integer deleteFlag, Long createdId, Date createdTime, Long modifiedId, Date modifiedTime) {

        this.doctorId = doctorId;
        this.agreementType = agreementType;
        this.version = version;
        this.deleteFlag = deleteFlag;
        this.createdId = createdId;
        this.createdTime = createdTime;
        this.modifiedId = modifiedId;
        this.modifiedTime = modifiedTime;
    }
}