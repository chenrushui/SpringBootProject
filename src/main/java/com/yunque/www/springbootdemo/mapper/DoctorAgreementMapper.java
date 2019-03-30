package com.yunque.www.springbootdemo.mapper;


import com.yunque.www.springbootdemo.pojo.DoctorAgreement;

import java.util.List;

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