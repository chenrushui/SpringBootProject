package com.yunque.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class DoctorTitle {
    private Integer id;

    private Integer titleId;

    private String name;

    private Integer seqNo;

    private Integer parentId;

    private Integer type;

    private Integer deleteFlag;

    private Integer creatId;

    private Date creatTime;

    private Integer modifyId;

    private Date modifyTime;


}