package com.yunque.www.springbootdemo.service;

import com.yunque.www.springbootdemo.pojo.DoctorAgreement;

import java.util.List;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:用户协议
 */
public interface AgreementService {
    /**
     * 根据协议类型查询协议列表
     *
     * @param agreementType
     * @return List<DoctorAgreementDto>
     */
    List<DoctorAgreement> getListByType(Integer agreementType);

    /**
     * 根据协议类型查询最新协议
     *
     * @param agreementType
     * @return DoctorAgreementDto
     */
    DoctorAgreement getLatestByType(int agreementType);

    /**
     * 保存用户同意的协议版本号
     *
     * @param doctorId      医生ID
     * @param agreementType 协议类型
     */
    void saveConsentVersion(long doctorId, Integer agreementType);

    /**
     * 校验用户是否需要重新同意协议
     *
     * @param doctorId      医生ID
     * @param agreementType 协议类型
     * @return boolean 是否需要重新同意协议
     */
    boolean checkConsentVersion(long doctorId, Integer agreementType);

}
