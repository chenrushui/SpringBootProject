package com.yunque.www.springbootdemo.controller;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.service.HospitalDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/4/9.
 * author:crs
 * Description:医院部门
 */
@RestController
@Api(description = "医院部门相关信息")
@RequestMapping("/hospitals")
public class HospitalDepartmentController {

    @Autowired
    private HospitalDepartmentService hospitalDepartmentService;

    @ApiOperation(value = "获取机构人数")
    @GetMapping(value = "/{hospitalId}/num",produces = "application/json;charset=utf-8")
    public BaseResult getNumberByHospitalId(@PathVariable("hospitalId") long hospitalId){
        int num = hospitalDepartmentService.getMemberNumByHospitalId(hospitalId);
        return BaseResult.buildSuccess(num);
    }

    //todo:一般情况下，get请求都要使用@RequestParam注解
    //todo：前端如何传递集合？localhost:8000/hospitals/list/num?hospitalIds=105933&hospitalIds=12682
    @ApiOperation(value = "查询多个机构的人数")
    @GetMapping(value = "/list/num",produces = "application/json;charset=utf-8")
    public BaseResult getNumberByHospitalIds(@RequestParam("hospitalIds") List<Long> hospitalIds){
        List<Map<String, Object>> list = hospitalDepartmentService.getMemberNumByHospitalIds(hospitalIds);
        return BaseResult.buildSuccess(list);
    }

    @ApiOperation(value = "查询多个机构的人数")
    @PostMapping(value = "/list/num",produces = "application/json;charset=utf-8")
    public BaseResult getMemberNumByHospitalIds(@RequestParam List<Long> hospitalIds){
        List<Map<String, Object>> list = hospitalDepartmentService.getMemberNumByHospitalIds(hospitalIds);
        return BaseResult.buildSuccess(list);
    }


}
