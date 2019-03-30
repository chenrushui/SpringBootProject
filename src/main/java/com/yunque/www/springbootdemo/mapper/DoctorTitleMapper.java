package com.yunque.www.springbootdemo.mapper;


import com.yunque.www.springbootdemo.pojo.DoctorTitle;

import java.util.List;

public interface DoctorTitleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DoctorTitle record);

    int insertSelective(DoctorTitle record);

    DoctorTitle selectByPrimaryKey(Integer id);

    /**
     * 通过类型获取职称等级
     * @param id
     * @return
     */
    List<DoctorTitle> selectByType(Integer id);

    /**
     * 获取所有的医生分类以及职称
     * @return
     */
    List<DoctorTitle> selectByAll();

    int updateByPrimaryKeySelective(DoctorTitle record);

    int updateByPrimaryKey(DoctorTitle record);
}