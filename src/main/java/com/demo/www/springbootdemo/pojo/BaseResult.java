package com.demo.www.springbootdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "BaseResult")
public class BaseResult<T> implements Serializable {
    //200 表示成功，-1表示失败
    @ApiModelProperty(value = "code")
    public int code;
    @ApiModelProperty
    public String message;
    @ApiModelProperty
    public T data;

    public BaseResult() {
    }

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功，传入数据
     *
     * @param obj
     * @return
     */
    public static BaseResult buildSuccess(Object obj) {
        return new BaseResult(200, "请求成功", obj);
    }

    /**
     * 只标识请求成功
     *
     * @return
     */
    public static BaseResult buildSuccess() {
        return new BaseResult(200, "请求成功", null);
    }

    /**
     * 成功，传入数据,及描述信息
     *
     * @param obj
     * @param msg
     * @return
     */
    public static BaseResult buildSuccess(Object obj, String msg) {
        return new BaseResult(200, msg, obj);
    }

    /**
     * 成功，传入数据,及状态码
     *
     * @param code
     * @param obj
     * @return
     */
    public static BaseResult buildSuccess(int code, Object obj) {
        return new BaseResult(code, "请求成功", obj);
    }


    /**
     * 失败，传入描述信息
     *
     * @param msg
     * @return
     */
    public static BaseResult buildError(String msg) {
        return new BaseResult(-1, msg, null);
    }

    /**
     * 失败，传入描述信息,状态码
     *
     * @param code
     * @param msg
     * @return
     */
    public static BaseResult buildError(int code, String msg) {
        return new BaseResult(code, msg, null);
    }
}
