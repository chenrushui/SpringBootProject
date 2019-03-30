package com.yunque.www.springbootdemo.service;

import com.yunque.www.springbootdemo.pojo.DoctorTitle;
import com.yunque.www.springbootdemo.pojo.DoctorTitleList;

import java.util.List;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:DoctorTitleService
 */
public interface DoctorTitleService {

    DoctorTitleList selectDoctorTitleById();

    List<DoctorTitle> selectDoctorTitle();



}
