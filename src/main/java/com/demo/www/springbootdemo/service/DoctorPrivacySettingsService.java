package com.demo.www.springbootdemo.service;

import com.demo.www.springbootdemo.pojo.DoctorPrivacySettings;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:隐私政策
 */
public interface DoctorPrivacySettingsService {
    /**
     * 保存设置信息
     *
     * @param record
     * @return
     */
    int insertSelective(DoctorPrivacySettings record);

    /**
     * 更新设置信息
     *
     * @param record
     * @return
     */
    int deleteByDoctorIdAndType(DoctorPrivacySettings record);

}
