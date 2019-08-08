package com.yunque.www.springbootdemo.controller;

import com.yunque.www.springbootdemo.enums.AgreementTypeEnum;
import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorAgreement;
import com.yunque.www.springbootdemo.redis.RedisUtils;
import com.yunque.www.springbootdemo.req.AgreementConsentReq;
import com.yunque.www.springbootdemo.service.AgreementService;
import org.apache.kafka.common.config.ConfigDef;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping(value = "/get", produces = "application/json;charset=utf-8")
    public BaseResult getAgreementContentByType(@RequestParam(value = "agreementType") Integer type) {
        DoctorAgreement doctorAgreement = agreementService.getLatestByType(type);
        BaseResult baseResult = new BaseResult();
        baseResult.setData(doctorAgreement);
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


    /**
     * 接口幂等性处理
     *
     * @param hospitalId
     * @return
     */
    @PostMapping(value = "/repeat")
    public BaseResult<String> processRepeatRequest(@RequestParam("hospitalId") int hospitalId) {
        if (StringUtils.isEmpty(redisUtils.get("cache_repeat_" + hospitalId))) {
            //1)如果没有处理过，进行处理
            String result = null;
            //2)返回给前端的同时，把数据存到redis中
            redisUtils.set("cache_repeat_" + hospitalId, result);
            return BaseResult.buildSuccess(result);
        } else {
            //如果处理过，直接返回值
            return BaseResult.buildSuccess(redisUtils.get("cache_repeat_" + hospitalId));
        }
    }

    /**
     * 通过版本号处理幂等
     *
     * @param id
     * @param name
     * @param version
     * @return
     */
    public boolean updateGoodsInfo(int id, String name, int version) {
        //对应的数据库中的sql:第一次版本号加1，后面不处理
        //update goods set name=#{name},version=version+1,where id=#{id} and version=#{version}
        return true;
    }


}
