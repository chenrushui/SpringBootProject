package com.yunque.www.springbootdemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//可以在主配置文件中进行统一的配置，值为null的进行统一过滤
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String password;
    private Date birthday;




}
