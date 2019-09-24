package com.demo.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Created on 2019/9/19 15:29
 * author:crs
 * Description:多数据源模型
 */
@Data
public class DataSourceEntity {
    private Integer id;

    private Integer sex;

    private String name;

    private String mobilePhone;

    private String tel;

    private Integer status;

    private Integer type;

    private Integer hospitalId;

    private Integer departmentId;

    private Integer titleId;

    private String hospital;

    private String department;

    private String title;

    private String certImageUrl;

    private String avatarImageUrl;

    private Date authTime;

    private String honor;

    private String skills;

    private Integer thumbUpNum;

    private String email;

    private String qrcode;

    private String nickname;

    private String personalSign;

    private Integer deleteFlag;

    private Integer creatId;

    private Date creatTime;

    private Integer modifyId;

    private Date modifyTime;

    private Integer praiseNum;

    private String password;

    private String info;

    private String rank;

    private Long province;

    private String provinceName;

    private Long city;

    private String cityName;

    private Long county;

    private String countyName;

    private Long town;

    private String townName;

    private String inviteCode;

    private Date inviteStartTime;

    private String gaoxueyaPassword;

    private Integer smsSendNum;

    private Integer totalSmsSendNum;

    private Boolean entireFlag;

    private Integer doctorProjectType;

    private Date regTime;

    private Date lastLoginTime;

    private String unionid;

    private Integer registerSource;

    private String comment;

    private Integer administerTitleId;

    private String administerTitle;

    private Integer registerType;

    private Date firstLoginTime;

    private String card;

    private Date birthday;

    private Integer showFlag;
}
