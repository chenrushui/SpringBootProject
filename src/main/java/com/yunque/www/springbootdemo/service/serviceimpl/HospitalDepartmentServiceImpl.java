package com.yunque.www.springbootdemo.service.serviceimpl;

import com.yunque.www.springbootdemo.mapper.DoctorHospitalMapper;
import com.yunque.www.springbootdemo.service.HospitalDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019/4/9.
 * author:crs
 * Description:HospitalDepartmentServiceImpl
 */
@Service
public class HospitalDepartmentServiceImpl implements HospitalDepartmentService {

    @Autowired
    private DoctorHospitalMapper doctorHospitalMapper;


    @Override
    public int getMemberNumByHospitalId(long hospitalId) {
        return doctorHospitalMapper.selectMemberNumByHospitalId(hospitalId);
    }

    @Override
    public List<Map<String, Object>> getMemberNumByHospitalIds(List<Long> hospitalIds) {
        //todo:判断集合是否为空
        if (CollectionUtils.isEmpty(hospitalIds)){
            return Collections.EMPTY_LIST;
        }
        return doctorHospitalMapper.selectMemberNumByHospitalIds(hospitalIds);
    }
}
