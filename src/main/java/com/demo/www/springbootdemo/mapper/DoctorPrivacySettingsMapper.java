package com.demo.www.springbootdemo.mapper;


import com.demo.www.springbootdemo.pojo.DoctorPrivacySettings;

public interface DoctorPrivacySettingsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DoctorPrivacySettings record);

    int insertSelective(DoctorPrivacySettings record);

    DoctorPrivacySettings selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DoctorPrivacySettings record);

    int updateByPrimaryKey(DoctorPrivacySettings record);
}