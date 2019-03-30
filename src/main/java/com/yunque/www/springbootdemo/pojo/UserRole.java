package com.yunque.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserRole {
    private Integer id;

    private String roleName;

    private String roleCode;

    private String remark;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Integer status;

    private Integer deleteFlag;

    private Integer creatId;

    private Date creatTime;

    private Integer modifyId;

    private Date modifyTime;


}