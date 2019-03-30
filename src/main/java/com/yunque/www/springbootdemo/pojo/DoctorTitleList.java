package com.yunque.www.springbootdemo.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 技术职称列表
 */
@Data
public class DoctorTitleList {

    private List<DoctorTitle> doctorTitles;

    private List<DoctorTitle> nurseTitles;

    private List<DoctorTitle> technicianTitles;

    public DoctorTitleList(List<DoctorTitle> doctorTitles, List<DoctorTitle> nurseTitles, List<DoctorTitle> technicianTitles) {
        this.doctorTitles = doctorTitles;
        this.nurseTitles = nurseTitles;
        this.technicianTitles = technicianTitles;
    }
}