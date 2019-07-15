package com.yunque.www.springbootdemo.controller;

import com.yunque.www.springbootdemo.anno.loginpermission.LoginPermission;
import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorEducation;
import com.yunque.www.springbootdemo.service.DoctorEducationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created on 2019/3/29.
 * author:crs
 * Description:医生的教育信息
 */
@Api(description = "用户教育信息")
@Slf4j
@RestController
@RequestMapping(value = "/education")
public class DoctorEducationController {

    @Autowired
    private DoctorEducationService doctorEducationService;

    /**
     * 查询教育信息
     *
     * @param doctorId
     * @return
     */
    @ApiOperation(value = "获取医生教育信息")
    @GetMapping(value = "/", produces = "application/json;charset=UTF-8")
    public BaseResult getDoctorEducationByDoctorId(@RequestParam("doctorId") Long doctorId) {
        ArrayList<DoctorEducation> list = new ArrayList<>();
        DoctorEducation doctorEducation = doctorEducationService.getDoctorEducationByDoctorId(doctorId);
        if (doctorEducation != null) {
            list.add(doctorEducation);
        }
        return BaseResult.buildSuccess(list);
    }

    @ApiOperation(value = "编辑医生教育信息")
    @PostMapping(value = "/edit", produces = "application/json;charset=UTF-8")
    public BaseResult editDoctorEducation(@RequestBody DoctorEducation doctorEducation) {
        int row = doctorEducationService.putDoctorEducation(doctorEducation);
        log.info("保存教育信息成功,医生id是：" + doctorEducation.getDoctorId());
        return BaseResult.buildSuccess(row);
    }

    @LoginPermission(value = "是否可以登陆？")
    @GetMapping("/anno")
    public BaseResult<String> getTestAnno() {
        return BaseResult.buildSuccess("登陆权限");

    }
}
