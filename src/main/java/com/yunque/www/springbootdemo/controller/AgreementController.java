package com.yunque.www.springbootdemo.controller;

import com.yunque.www.springbootdemo.enums.AgreementTypeEnum;
import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorAgreement;
import com.yunque.www.springbootdemo.req.AgreementConsentReq;
import com.yunque.www.springbootdemo.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:用户协议
 */
@RestController
@RequestMapping(value = "/agreement")
public class AgreementController {

    @Autowired
    private AgreementService agreementService;

    @GetMapping(value = "/get", produces = "application/json;charset=utf-8")
    public BaseResult getAgreementContentByType(@RequestParam(value = "agreementType") Integer type) {
        DoctorAgreement doctorAgreement = agreementService.getLatestByType(type);
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(doctorAgreement);
        baseResult.setCode(200);
        baseResult.setMessage("请求成功！");
        return baseResult;
    }

    /**
     * 保护用户同意的版本号（用户协议可能会更新）
     * 用户同意的协议类型，用户id，用户协议的版本号
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/save", produces = "application/json;charset=utf-8")
    public BaseResult saveAgreementVersion(@RequestBody AgreementConsentReq req) {
        Long doctorId = req.getDoctorId();
        Integer agreementType = req.getAgreementType();
        agreementService.saveConsentVersion(doctorId, agreementType);
        return BaseResult.buildSuccess();
    }


    /**
     * 获取最新的未读的协议
     *
     * @param doctorId
     * @return
     */
    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    public BaseResult getAllAgreementContent(@RequestParam("doctorId") long doctorId) {
        ArrayList<Integer> list = new ArrayList<>();
        if (agreementService.checkConsentVersion(doctorId, AgreementTypeEnum.USER_AGREEMENT.getCode())) {
            list.add(AgreementTypeEnum.USER_AGREEMENT.getCode());
        }
        if (agreementService.checkConsentVersion(doctorId, AgreementTypeEnum.PRIVATE_AGREEMENT.getCode())) {
            list.add(AgreementTypeEnum.PRIVATE_AGREEMENT.getCode());
        }
        return BaseResult.buildSuccess(list);
    }


}
