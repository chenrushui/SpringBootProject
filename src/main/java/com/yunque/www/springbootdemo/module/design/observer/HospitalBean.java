package com.yunque.www.springbootdemo.module.design.observer;

/**
 * Created on 2019/1/29.
 *
 * @author:crs Description:HospitalBean
 */

public class HospitalBean {
    private int hospitalId;
    private String hospitalName;
    private String hospitalAddress;

    public HospitalBean() {
    }

    public HospitalBean(int hospitalId, String hospitalName, String hospitalAddress) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    @Override
    public String toString() {
        return "HospitalBean{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalAddress='" + hospitalAddress + '\'' +
                '}';
    }
}
