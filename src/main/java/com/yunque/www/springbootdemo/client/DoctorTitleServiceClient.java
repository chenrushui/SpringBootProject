package com.yunque.www.springbootdemo.client;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorTitle;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created on 2019/4/10.
 * author:crs
 * Description:DoctorTitleServiceClient
 */
//@FeignClient(value = "spring-boot-micro-8000")
public interface DoctorTitleServiceClient {

    @GetMapping(value = "/list/type", produces = "application/json;charset=utf-8")
    BaseResult<DoctorTitle> getDoctorTitleList();

    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    BaseResult<DoctorTitle> getAllDoctorTitle();
}
