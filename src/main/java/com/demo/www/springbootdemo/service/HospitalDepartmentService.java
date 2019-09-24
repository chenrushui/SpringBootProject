package com.demo.www.springbootdemo.service;

import com.demo.www.springbootdemo.pojo.HospitalDepartmentMemberDto;

import java.util.List;
import java.util.Map;

/**
 * Created on 2019/4/9.
 * author:crs
 * Description:HospitalDepartmentService
 */

public interface HospitalDepartmentService {

    /**
     * 重置机构的加入方式
     */
    Integer resetJoinWay();


    /**
     * 获取机构人数
     *
     * @param hospitalId
     * @return
     */
    int getMemberNumByHospitalId(long hospitalId);

    /**
     * 获取多个部门的机构人数
     *
     * @param hospitalIds
     * @return
     */
    List<Map<String, Object>> getMemberNumByHospitalIds(List<Long> hospitalIds);

    /**
     * 获取部门下人员数量
     *
     * @param hospitalId
     * @param departmentId
     * @return
     */
    int getHospitalDepartmentMemberNum(long hospitalId, long departmentId);


    /**
     * 获取有人员的科室以及人数
     *
     * @param hospitalId
     * @return
     */
    List<HospitalDepartmentMemberDto> getDepartmentMemberByHospitalId(long hospitalId);


}
