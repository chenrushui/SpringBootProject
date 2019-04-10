package com.yunque.www.springbootdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created on 2019/4/10.
 * author:crs
 * Description:医院部门成员
 */
@Data
@ApiModel(value = "医院部门人员数")
public class HospitalDepartmentMemberDto {
    @ApiModelProperty(value = "部门id，0表示无科室")
    private long departmentId;
    @ApiModelProperty(value = "部门人数")
    private int memberNum;
}
