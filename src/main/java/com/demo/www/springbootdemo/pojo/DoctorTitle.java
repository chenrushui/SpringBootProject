package com.demo.www.springbootdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "DoctorTitle")
public class DoctorTitle {
    private Integer id;

    @ApiModelProperty("titleId")
    private Integer titleId;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("seqNo")
    private Integer seqNo;

    @ApiModelProperty("parentId")
    private Integer parentId;

    @ApiModelProperty("type")
    private Integer type;

    @ApiModelProperty("deleteFlag")
    private Integer deleteFlag;

    @ApiModelProperty("creatId")
    private Integer creatId;

    @ApiModelProperty("creatTime")
    private Date creatTime;

    @ApiModelProperty("modifyId")
    private Integer modifyId;

    @ApiModelProperty("modifyTime")
    private Date modifyTime;


}