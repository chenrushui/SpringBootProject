package com.yunque.www.springbootdemo.req;

import lombok.Data;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:请求数据模型
 */
@Data
public class AgreementConsentReq {
    private Long doctorId;

    private String mobilePhone;

    private Integer agreementType;
}
