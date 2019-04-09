package com.yunque.www.springbootdemo.service;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/4/9.
 * author:crs
 * Description:HospitalDepartmentService
 */
public interface HospitalDepartmentService {


    /**
     * 获取机构人数
     *
     * @param hospitalId
     * @return
     */
    int getMemberNumByHospitalId(long hospitalId);

    /**
     * 获取多个部门的机构人数
     * @param hospitalIds
     * @return
     */
    List<Map<String,Object>> getMemberNumByHospitalIds(List<Long> hospitalIds);


}
