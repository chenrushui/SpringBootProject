package com.yunque.www.springbootdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class DoctorEducation {
    @ApiModelProperty
    private Integer id;

    @ApiModelProperty("医生id")
    private Long doctorId;

    @ApiModelProperty("学校名称")
    private String schoolName;

    @ApiModelProperty("专业id")
    private Integer majorId;

    @ApiModelProperty("专业名称")
    private String majorName;

    @ApiModelProperty("学历id")
    private String educationId;

    @ApiModelProperty("毕业学校")
    private String educationName;

    @ApiModelProperty("入学年份")
    private String year;

    @ApiModelProperty("毕业年份")
    private String graduatedYear;

    @ApiModelProperty
    private Integer deleteFlag;

    @ApiModelProperty
    private Long creatId;

    @ApiModelProperty
    private Date creatTime;

    @ApiModelProperty
    private Long modifyId;

    @ApiModelProperty
    private Date modifyTime;


}