package com.demo.www.springbootdemo.client;

import com.demo.www.springbootdemo.pojo.BaseResult;
import com.demo.www.springbootdemo.pojo.DoctorPrivacySettings;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created on 2019/4/10.
 * author:crs
 * Description:DoctorPrivacySettingsServiceClient
 */
//@FeignClient(value = "spring-boot-micro-8000")
public interface DoctorPrivacySettingsServiceClient {

    @PostMapping(value = "/show")
    BaseResult showDoctorPrivacy(@RequestBody DoctorPrivacySettings doctorPrivacySettings);
}
