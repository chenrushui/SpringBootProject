package com.demo.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SysUserRoleJoinBean {
    private Long id;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date createTime;

    private SysRoleBean sysRoleBean;

    private String roleName;

    private Integer enabled;

    private Long createBy;


}