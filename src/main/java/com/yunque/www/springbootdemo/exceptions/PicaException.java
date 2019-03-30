package com.yunque.www.springbootdemo.exceptions;

import lombok.Data;

/**
 * Created on 2019/3/17.
 * author:crs
 * Description:自定义异常模型
 */
@Data
public class PicaException extends RuntimeException {
    private String code;
    private String msg;

    public PicaException(String code, String msg) {
        this(code, msg, (Throwable) null);
    }

    public PicaException(String code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public PicaException(PicaResultCode picaResultCode, Throwable cause) {
        super(cause);
        this.code = picaResultCode.getCode();
        this.msg = picaResultCode.getMessage();
    }

    public PicaException(PicaResultCode picaResultCode) {
        this.code = picaResultCode.getCode();
        this.msg = picaResultCode.getMessage();
    }


}
