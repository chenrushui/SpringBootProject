package com.demo.www.springbootdemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 1）实现序列化接口，要在进程间通讯
 * 2）把所有的异常情况抽取一个枚举类型进行统一封装
 *
 * @param <T>
 */
@Data
public class BaseBean<T> implements Serializable {

    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    public static final int NO_PERMISSION = 2;

    private String message;
    private String code;
    private T data;

}
