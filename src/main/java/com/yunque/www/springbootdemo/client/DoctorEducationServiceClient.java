package com.yunque.www.springbootdemo.client;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorEducation;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 2019/3/29.
 * author:crs
 * Description:医生的教育信息
 */

//@FeignClient(value = "spring-boot-micro-8000")
public interface DoctorEducationServiceClient {

    /**
     * 查询教育信息
     *
     * @param doctorId
     * @return
     */
    @ApiOperation(value = "获取医生教育信息")
    @GetMapping(value = "/", produces = "application/json;charset=UTF-8")
    BaseResult getDoctorEducationByDoctorId(@RequestParam("doctorId") Long doctorId);

    @ApiOperation(value = "编辑医生教育信息")
    @PostMapping(value = "/edit", produces = "application/json;charset=UTF-8")
    BaseResult editDoctorEducation(@RequestBody DoctorEducation doctorEducation);
}
