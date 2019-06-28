package com.yunque.www.springbootdemo.controller;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorPrivacySettings;
import com.yunque.www.springbootdemo.service.DoctorPrivacySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:隐私政策，有多种类型
 */
@RestController
@RequestMapping(value = "/privacy")
public class DoctorPrivacySettingsController {

    @Autowired
    private DoctorPrivacySettingsService doctorPrivacySettingsService;

    @PostMapping(value = "/show")
    public BaseResult showDoctorPrivacy(@RequestBody DoctorPrivacySettings doctorPrivacySettings) {
        int i = doctorPrivacySettingsService.insertSelective(doctorPrivacySettings);
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(i);
        baseResult.setCode(200);
        baseResult.setMessage("请求成功！");
        return baseResult;

    }


}
