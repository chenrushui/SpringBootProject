package com.yunque.www.springbootdemo.client;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorPrivacySettings;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created on 2019/4/10.
 * author:crs
 * Description:DoctorPrivacySettingsServiceClient
 */
@FeignClient(value = "spring-boot-micro-8000")
public interface DoctorPrivacySettingsServiceClient {

    @PostMapping(value = "/show")
    BaseResult showDoctorPrivacy(@RequestBody DoctorPrivacySettings doctorPrivacySettings);
}
