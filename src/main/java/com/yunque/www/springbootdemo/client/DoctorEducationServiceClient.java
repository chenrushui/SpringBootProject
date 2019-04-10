package com.yunque.www.springbootdemo.client;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorEducation;
import com.yunque.www.springbootdemo.service.DoctorEducationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created on 2019/3/29.
 * author:crs
 * Description:医生的教育信息
 */

@FeignClient(value = "spring-boot-micro-8000")
public interface DoctorEducationServiceClient {

    /**
     * 查询教育信息
     * @param doctorId
     * @return
     */
    @ApiOperation(value = "获取医生教育信息")
    @GetMapping(value = "/",produces = "application/json;charset=UTF-8")
     BaseResult getDoctorEducationByDoctorId(@RequestParam("doctorId") Long doctorId);

    @ApiOperation(value = "编辑医生教育信息")
    @PostMapping(value = "/edit",produces = "application/json;charset=UTF-8")
      BaseResult editDoctorEducation(@RequestBody DoctorEducation doctorEducation);
}
