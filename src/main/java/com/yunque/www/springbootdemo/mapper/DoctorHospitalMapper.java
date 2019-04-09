package com.yunque.www.springbootdemo.mapper;


import com.yunque.www.springbootdemo.pojo.DoctorHospital;

import java.util.List;
import java.util.Map;

public interface DoctorHospitalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DoctorHospital record);

    int insertSelective(DoctorHospital record);

    DoctorHospital selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DoctorHospital record);

    int updateByPrimaryKey(DoctorHospital record);

    int selectMemberNumByHospitalId(long hospitalId);

    List<Map<String, Object>> selectMemberNumByHospitalIds(List<Long> hospitalIds);

}