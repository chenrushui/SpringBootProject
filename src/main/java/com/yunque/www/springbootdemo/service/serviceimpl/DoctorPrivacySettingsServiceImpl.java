package com.yunque.www.springbootdemo.service.serviceimpl;

import com.yunque.www.springbootdemo.mapper.DoctorPrivacySettingsMapper;
import com.yunque.www.springbootdemo.pojo.DoctorPrivacySettings;
import com.yunque.www.springbootdemo.service.DoctorPrivacySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:
 */
@Service
public class DoctorPrivacySettingsServiceImpl extends BaseServiceImpl implements DoctorPrivacySettingsService {
    @Autowired
    private DoctorPrivacySettingsMapper doctorPrivacySettingsMapper;

    @Override
    public int insertSelective(DoctorPrivacySettings record) {
        return doctorPrivacySettingsMapper.insertSelective(record);
    }

    @Override
    public int deleteByDoctorIdAndType(DoctorPrivacySettings record) {
        return doctorPrivacySettingsMapper.updateByPrimaryKeySelective(record);
    }
}
