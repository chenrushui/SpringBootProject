package com.yunque.www.springbootdemo.client;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.req.AgreementConsentReq;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:用户协议
 */

@FeignClient(value = "spring-boot-micro-8000")
public interface AgreementServiceClient {

    @GetMapping(value = "/get", produces = "application/json;charset=utf-8")
    BaseResult getAgreementContentByType(@RequestParam(value = "agreementType") Integer type);

    /**
     * 保护用户同意的版本号（用户协议可能会更新）
     * 用户同意的协议类型，用户id，用户协议的版本号
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/save", produces = "application/json;charset=utf-8")
    BaseResult saveAgreementVersion(@RequestBody AgreementConsentReq req);

    /**
     * 获取最新的未读的协议
     *
     * @param doctorId
     * @return
     */
    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    BaseResult getAllAgreementContent(@RequestParam("doctorId") long doctorId);

}
