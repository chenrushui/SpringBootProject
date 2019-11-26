package com.demo.www.springbootdemo.module.mongdb;

/**
 * Created on 2019/10/21 17:45
 * author:crs
 * Description:XXX
 */
public class EcosSytemEntity {
    private String adminCaption;
    private String adminId;
    //生态圈中包含的机构
    private String hierarchy;
    //生态圈名称
    private String name;

    public String getAdminCaption() {
        return adminCaption;
    }

    public void setAdminCaption(String adminCaption) {
        this.adminCaption = adminCaption;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EcosSytemEntity{" +
                "adminCaption='" + adminCaption + '\'' +
                ", adminId='" + adminId + '\'' +
                ", hierarchy='" + hierarchy + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
