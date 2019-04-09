package com.yunque.www.springbootdemo.controller;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.DoctorTitle;
import com.yunque.www.springbootdemo.pojo.DoctorTitleList;
import com.yunque.www.springbootdemo.service.DoctorTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:医生分类以及等级
 */
@RestController
@RequestMapping("/title")
public class DoctorTitleController {

    @Autowired
    private DoctorTitleService doctorTitleService;

    @GetMapping(value = "/list/type", produces = "application/json;charset=utf-8")
    public BaseResult<DoctorTitle> getDoctorTitleList() {
        DoctorTitleList doctorTitleList = doctorTitleService.selectDoctorTitleById();
        BaseResult baseResult = new BaseResult();
        baseResult.setMessage("请求成功");
        baseResult.setCode(200);
        baseResult.setResult(doctorTitleList);
        return baseResult;
    }

    @GetMapping(value = "/list", produces = "application/json;charset=utf-8")
    public BaseResult<DoctorTitle> getAllDoctorTitle() {
        List<DoctorTitle> doctorTitles = doctorTitleService.selectDoctorTitle();
        BaseResult baseResult = new BaseResult();
        baseResult.setMessage("请求成功");
        baseResult.setCode(200);
        baseResult.setResult(doctorTitles);
        return baseResult;
    }
}
