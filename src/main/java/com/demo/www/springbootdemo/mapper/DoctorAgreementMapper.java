package com.demo.www.springbootdemo.mapper;


import com.demo.www.springbootdemo.pojo.DoctorAgreement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorAgreementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DoctorAgreement record);

    int insertSelective(DoctorAgreement record);

    DoctorAgreement selectByPrimaryKey(int id);

    DoctorAgreement selectByAgreementType(int id);

    List<DoctorAgreement> selectAgreementListById(Long id);

    int updateByPrimaryKeySelective(DoctorAgreement record);

    int updateByPrimaryKeyWithBLOBs(DoctorAgreement record);

    int updateByPrimaryKey(DoctorAgreement record);
}