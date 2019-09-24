package com.demo.www.springbootdemo.service.serviceimpl;

import com.demo.www.springbootdemo.service.HospitalDepartmentService;
import com.demo.www.springbootdemo.mapper.DoctorHospitalMapper;
import com.demo.www.springbootdemo.pojo.HospitalDepartmentMemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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


    /**
     * 重置机构的加入方式
     */
    @Override
    public Integer resetJoinWay() {
        return 0;

    }

    @Override
    public int getMemberNumByHospitalId(long hospitalId) {
        return doctorHospitalMapper.selectMemberNumByHospitalId(hospitalId);
    }

    @Override
    public List<Map<String, Object>> getMemberNumByHospitalIds(List<Long> hospitalIds) {
        if (CollectionUtils.isEmpty(hospitalIds)) {
            return Collections.EMPTY_LIST;
        }
        return doctorHospitalMapper.selectMemberNumByHospitalIds(hospitalIds);
    }

    @Override
    public int getHospitalDepartmentMemberNum(long hospitalId, long departmentId) {
        return doctorHospitalMapper.selectMemberNumByHospitalIdAndDepartmentId(hospitalId, departmentId);
    }

    @Override
    public List<HospitalDepartmentMemberDto> getDepartmentMemberByHospitalId(long hospitalId) {
        return doctorHospitalMapper.getDepartmentMemberByHospitalId(hospitalId, null);
    }
}
