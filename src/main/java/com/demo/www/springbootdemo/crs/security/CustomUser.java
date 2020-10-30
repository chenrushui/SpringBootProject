package com.demo.www.springbootdemo.crs.security;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomUser {
    @NotBlank(message = "手机号不能为空")
    private String mobile;
    @NotBlank(message = "密码不能为空")
    private String password;
}
