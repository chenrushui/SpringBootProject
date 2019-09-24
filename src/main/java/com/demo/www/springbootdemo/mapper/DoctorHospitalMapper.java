package com.demo.www.springbootdemo.mapper;


import com.demo.www.springbootdemo.pojo.DoctorHospital;
import com.demo.www.springbootdemo.pojo.HospitalDepartmentMemberDto;

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

    int selectMemberNumByHospitalIdAndDepartmentId(long hospitalId, long departmentId);

    List<HospitalDepartmentMemberDto> getDepartmentMemberByHospitalId(long hospitalId, List<Long> doctorIds);

}