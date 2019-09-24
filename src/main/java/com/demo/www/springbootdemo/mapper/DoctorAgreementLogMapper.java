package com.demo.www.springbootdemo.mapper;


import com.demo.www.springbootdemo.pojo.DoctorAgreementLog;
import org.apache.ibatis.annotations.Param;

public interface DoctorAgreementLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DoctorAgreementLog record);

    int insertSelective(DoctorAgreementLog record);

    DoctorAgreementLog selectByPrimaryKey(Long id);

    DoctorAgreementLog selectLatestByDoctorIdAndType(@Param("doctorId") Long doctorId, @Param("agreementType") int agreement_type);

    int updateByPrimaryKeySelective(DoctorAgreementLog record);

    int updateByPrimaryKey(DoctorAgreementLog record);
}