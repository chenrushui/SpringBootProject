package com.demo.www.springbootdemo.exceptions.demo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 返回数据模型
 *
 * @param <T>
 */
public class BaseResponse<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    private BaseResponse() {
    }

    private BaseResponse(BaseResponse.Builder<T> builder) {
        data = builder.date;
        msg = builder.msg;
        code = builder.code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static BaseResponse toResponse() {
        return toResponse((Object) null);
    }

    public static BaseResponse toResponse(Object obj) {
        return toResponse(obj, BaseResultCode.SUCCESS);
    }

    public static BaseResponse toResponse(Object obj, BaseResultCode baseResultCode) {
        return toResponse(obj, baseResultCode.getCode(), baseResultCode.getMessage());
    }

    public static BaseResponse toResponse(Object obj, String code, String msg) {
        BaseResponse.Builder build = new BaseResponse.Builder<>();
        if (obj == null) {
            obj = new Object();
        }
        return build.setDate(obj).setCode(code).setMsg(msg).build();
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 静态内部类
     */
    public static class Builder<T> {
        private T date = null;
        private String code;
        private String msg;

        public Builder() {
            this.code = BaseResultCode.SUCCESS.getCode();
            this.msg = BaseResultCode.SUCCESS.getMessage();
        }

        public BaseResponse build() {
            return new BaseResponse(this);
        }


        public BaseResponse.Builder<T> setDate(T date) {
            this.date = date;
            return this;
        }

        public BaseResponse.Builder<T> setDate(String json, Class<T> zClass) {
            this.date = JSON.parseObject(json, zClass);
            return this;
        }


        public BaseResponse.Builder<T> setCode(String code) {
            this.code = code;
            return this;
        }

        public BaseResponse.Builder<T> setMsg(String msg) {
            this.msg = msg;
            return this;
        }
    }
}
