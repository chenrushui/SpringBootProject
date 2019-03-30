package com.yunque.www.springbootdemo.service.serviceimpl;

import com.yunque.www.springbootdemo.exceptions.PicaException;
import com.yunque.www.springbootdemo.exceptions.PicaResultCode;
import com.yunque.www.springbootdemo.mapper.DoctorEducationMapper;
import com.yunque.www.springbootdemo.pojo.DoctorEducation;
import com.yunque.www.springbootdemo.service.DoctorEducationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created on 2019/3/29.
 * author:crs
 * Description:
 */
@Slf4j
@Service
public class DoctorEducationServiceImpl implements DoctorEducationService {

    @Autowired
    private DoctorEducationMapper doctorEducationMapper;


    @Override
    public DoctorEducation getDoctorEducationByDoctorId(Long doctor) {
        DoctorEducation doctorEducation = doctorEducationMapper.selectByDoctorId(doctor);
        if (doctorEducation!=null){
            return doctorEducation;
        }
        return null;
    }

    @Override
    public int putDoctorEducation(DoctorEducation doctorEducation) {
        try {
            int result;
            Date currentTimes = new Date();
            DoctorEducation mDoctorEducation = new DoctorEducation();
            //todo：相当于是原型模式，bean复制，效率高
            BeanUtils.copyProperties(doctorEducation,mDoctorEducation);

            //todo：如果能够查到数据，就进行更新操作；如果查不到数据，就进行插入操作
            DoctorEducation origin = doctorEducationMapper.selectByDoctorId(mDoctorEducation.getDoctorId());
            if (origin!=null){
                mDoctorEducation.setModifyId(mDoctorEducation.getDoctorId());
                mDoctorEducation.setModifyTime(currentTimes);
                result= doctorEducationMapper.updateByDoctorIdSelective(mDoctorEducation);
            }else{
                mDoctorEducation.setModifyId(mDoctorEducation.getDoctorId());
                mDoctorEducation.setModifyTime(currentTimes);
                mDoctorEducation.setCreatId(mDoctorEducation.getDoctorId());
                mDoctorEducation.setCreatTime(currentTimes);
                mDoctorEducation.setDeleteFlag(1);
                result= doctorEducationMapper.insertSelective(mDoctorEducation);
            }
            return result;
        } catch (BeansException ex) {
            log.error(ex.getMessage(),ex);
            //todo:抛出一个自定义的异常
            throw new PicaException(PicaResultCode.INTERFACE_INVOKE_EXCEPTION);
        }
    }
}
