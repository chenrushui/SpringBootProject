package com.demo.www.springbootdemo.service.serviceimpl;

import com.demo.www.springbootdemo.enums.DoctorTitleEnum;
import com.demo.www.springbootdemo.mapper.DoctorTitleMapper;
import com.demo.www.springbootdemo.pojo.DoctorTitle;
import com.demo.www.springbootdemo.pojo.DoctorTitleList;
import com.demo.www.springbootdemo.service.DoctorTitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:DoctorTitleServiceImpl
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS)  // TODO: 2019/3/27
public class DoctorTitleServiceImpl extends BaseServiceImpl implements DoctorTitleService {
    @Autowired
    DoctorTitleMapper doctorTitleMapper;

    @Override
    public DoctorTitleList selectDoctorTitleById() {
        List<DoctorTitle> doctorTitles = doctorTitleMapper.selectByType(DoctorTitleEnum.doctor_type.getCode());
        List<DoctorTitle> nurseTitles = doctorTitleMapper.selectByType(DoctorTitleEnum.nurse_type.getCode());
        List<DoctorTitle> echnicianTitles = doctorTitleMapper.selectByType(DoctorTitleEnum.echnician_type.getCode());
        DoctorTitleList doctorTitleList = new DoctorTitleList(doctorTitles, nurseTitles, echnicianTitles);
        log.info("------>" + doctorTitleList.toString());
        return doctorTitleList;
    }

    @Override
    public List<DoctorTitle> selectDoctorTitle() {
        List<DoctorTitle> doctorTitles = doctorTitleMapper.selectByAll();
        log.info("------>" + doctorTitles.toString());
        return doctorTitles;
    }
}
