package com.yunque.www.springbootdemo.service;

import com.yunque.www.springbootdemo.pojo.DoctorEducation;

/**
 * Created on 2019/3/29.
 * author:crs
 * Description:医生教育信息服务
 */
public interface DoctorEducationService {

    DoctorEducation getDoctorEducationByDoctorId(Long doctor);

    int putDoctorEducation(DoctorEducation doctorEducation);
}
