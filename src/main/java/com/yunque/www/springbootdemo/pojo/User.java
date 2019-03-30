package com.yunque.www.springbootdemo.pojo;

import lombok.Data;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//可以在主配置文件中进行统一的配置，值为null的进行统一过滤
@Data
public class User {

    private String name;
    private String password;


}
