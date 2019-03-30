package com.yunque.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SysUserBean {
    private Long id;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date createTime;

    private SysRoleBean sysRoleBean;


}