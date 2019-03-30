package com.yunque.www.springbootdemo.service.serviceimpl;

import com.yunque.www.springbootdemo.enums.AgreementTypeEnum;
import com.yunque.www.springbootdemo.mapper.DoctorAgreementLogMapper;
import com.yunque.www.springbootdemo.mapper.DoctorAgreementMapper;
import com.yunque.www.springbootdemo.pojo.DoctorAgreement;
import com.yunque.www.springbootdemo.pojo.DoctorAgreementLog;
import com.yunque.www.springbootdemo.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created on 2019/3/27.
 * author:crs
 * Description:用户协议
 */
@Service
public class AgreementServiceImpl implements AgreementService {


    @Autowired
    private DoctorAgreementMapper agreementMapper;

    @Autowired
    private DoctorAgreementLogMapper doctorAgreementLogMapper;


    @Override
    public List<DoctorAgreement> getListByType(Integer agreementType) {
        return null;
    }

    @Override
    public DoctorAgreement getLatestByType(int agreementType) {
        return agreementMapper.selectByAgreementType(agreementType);
    }

    //保存用户同意的协议版本号
    @Override
    public void saveConsentVersion(long doctorId, Integer agreementType) {
        if (agreementType==null){
            //保存用户协议
            this.saveAgreementProtocol(doctorId, AgreementTypeEnum.USER_AGREEMENT.getCode(),null);
            //保存隐私协议
            this.saveAgreementProtocol(doctorId, AgreementTypeEnum.PRIVATE_AGREEMENT.getCode(),null);

        }else{
            this.saveAgreementProtocol(doctorId,agreementType,null);
        }
    }

    @Override
    public boolean checkConsentVersion(long doctorId, Integer agreementType) {
        if (doctorId==0){
            return false;
        }
        DoctorAgreement doctorAgreement = agreementMapper.selectByAgreementType(agreementType);
        DoctorAgreementLog latestAgreement = doctorAgreementLogMapper.selectLatestByDoctorIdAndType(doctorId, agreementType);
        if (latestAgreement==null){
            //未获取到用户的协议信息
            return false;
        }
        if (doctorAgreement!=null){
            String version = doctorAgreement.getVersion();
            if (version.equals(latestAgreement.getVersion())){
                //用户已经同意的协议版本号与最新版本号相同
                return false;
            }
        }
        //需要获取最新版本的协议
        return true;
    }

    /**
     * todo：单独抽出一个方法进行业务逻辑的处理
     * 保存用户协议
     * @param doctorId
     * @param agreementType
     * @param version
     */
    private void saveAgreementProtocol(long doctorId, Integer agreementType, String version) {
        if (StringUtils.isEmpty(version)){
            //查询用户协议的版本号
            DoctorAgreement doctorAgreement = getLatestByType(agreementType);
            if (doctorAgreement==null){
                //todo:return null与return;的区别
                return;
            }
            version=doctorAgreement.getVersion();

        }
        //todo：创建pojo进行操作
        //todo:创建pojo的时候，其他字段是在构造函数中补全的，这种方式处理特别好。
        DoctorAgreementLog doctorAgreementLog = new DoctorAgreementLog(doctorId,agreementType,version);
        doctorAgreementLogMapper.insertSelective(doctorAgreementLog);
    }

}
