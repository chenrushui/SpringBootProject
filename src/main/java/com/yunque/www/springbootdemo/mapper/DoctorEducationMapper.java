package com.yunque.www.springbootdemo.mapper;


import com.yunque.www.springbootdemo.pojo.DoctorEducation;

public interface DoctorEducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DoctorEducation record);

    int insertSelective(DoctorEducation record);

    DoctorEducation selectByDoctorId(Long id);

    int updateByDoctorIdSelective(DoctorEducation record);

    int updateByDoctorId(DoctorEducation record);

    int updateByPrimaryKey(DoctorEducation record);
}