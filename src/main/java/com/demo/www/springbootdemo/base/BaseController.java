package com.demo.www.springbootdemo.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.www.springbootdemo.exceptions.PicaException;
import com.demo.www.springbootdemo.exceptions.PicaResultCode;
import com.demo.www.springbootdemo.pojo.BaseResult;
import com.demo.www.springbootdemo.module.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseController {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RedisUtils redisUtils;

    //todo:把通用性的操作封装到父类里面
    @Autowired
    private DoctorServiceClient doctorServiceClient;

    @Autowired
    private PermissionServiceClient permissionServiceClient;


    public PicaUser getPicaUser() {
        return this.getCurrentPicaUser();
    }

    public PicaUser fetchPicaUser() {
        return this.getCurrentPicaUser();
    }


    /**
     * 封装统一的返回对象
     *
     * @param data
     * @param <T>
     * @return
     */
    public <T> BaseResult<T> getBaseResult(T data) {
        BaseResult baseResult = BaseResult.buildSuccess();
        baseResult.setData(data);
        return baseResult;
    }

    /**
     * 获取PicaUser
     *
     * @return
     */
    public PicaUser getCurrentPicaUser() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader("token");
        PicaUser picaUser = null;
        if (StringUtils.isEmpty(token)) {
            return null;
        } else {
            //封装redis中的方法
            picaUser = redisUtils.getToken(token, PicaUser.class);
            if (picaUser != null) {
                picaUser.setToken(token);
            }
        }
        return picaUser;
    }

    /**
     * 从请求头中获取token
     *
     * @return
     */
    public String getTokenFromHeader() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getHeader("token");
    }

    /**
     * 从请求头中获取系统code
     *
     * @return
     */
    public String getSysCodeFromHeader() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getHeader("sysCode");
    }

    /**
     * 从请求头中获取设备信息
     *
     * @return
     */
    public String getDeviceInfoFromHeader() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getHeader("deviceInfo");
    }

    /**
     * 获取请求头信息
     *
     * @return
     */
    public Map<String, Object> getHeader() {
        Map<String, Object> map = new HashMap<>();
        map.put("picaUser", this.getCurrentPicaUser());
        map.put("sysCode", this.getSysCodeFromHeader());
        map.put("deviceInfo", this.getDeviceInfoFromHeader());
        return map;
    }

    /**
     * 获取请求的ip地址
     *
     * @return
     */
    protected final String getIpAddr() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }


    /**
     * 获取app版本号
     *
     * @return
     */
    public String getAppVersion() {
        String deviceInfoFromHeader = this.getDeviceInfoFromHeader();
        if (StringUtils.isEmpty(deviceInfoFromHeader)) {
            return "";
        }
        //todo：转化成json字符串获取其中某一个键值对的值
        try {
            JSONObject jsonObject = JSONObject.parseObject(deviceInfoFromHeader);
            return jsonObject.getString("app_version");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取userId
     *
     * @return
     */
    public long getUserIdByToken() {
        try {
            PicaUser picaUser = this.getCurrentPicaUser();
            return picaUser.getId().longValue();
        } catch (Exception e) {
            e.printStackTrace();
            //todo：直接抛出异常
            throw new PicaException(PicaResultCode.LOGIN_FAIL);
        }
    }

    /**
     * 从token获取userId，如果获取不到则抛出异常
     *
     * @return
     */
    public long fetchUserIdByToken() {
        String token = this.getTokenFromHeader();
        if (StringUtils.isEmpty(token)) {
            throw new PicaException(PicaResultCode.LOGIN_FAIL);
        }
        return this.getUserIdByToken();
    }

    /**
     * 获取当前用户的角色
     *
     * @return
     */
    public List<PermissionRoleDto> getRoles() {
        long userId = this.getUserIdByToken();
        DoctorHospitalDto doctorHospitalDto = (DoctorHospitalDto) doctorServiceClient.getHospitalInfoById(userId).getData();
        if (doctorHospitalDto == null || doctorHospitalDto.getHospitalId() == null) {
            throw new PicaException("40000", "权限被拒绝");
        }
        List<PermissionRoleDto> roles = (List<PermissionRoleDto>) permissionServiceClient.getPermissionRoles(userId).getData();
        if (!CollectionUtils.isEmpty(roles)) {
            return roles;
        }
        return null;
    }

    /**
     * 发送短息
     */
    public void sendMessage(String mobile, String content, String senderId) {
        Map<Object, Object> map = new HashMap<>();
        map.put("mobileSmsEntityContentList", new ArrayList<>());
        map.put("sign", "sign");
        map.put("userId", senderId);
        map.put("batchNo", "batchNo");
        //todo：把集合转化成字符串
        String data = JSON.toJSONString(map);
        //进行发送短息的操作,发送一个网络请求
        //判断短信发送的结果
        String jsonObj = "";
        if (StringUtils.isEmpty(jsonObj)) {
            logger.info("发送短信成功，返回结果：{}", jsonObj);
        } else {
            logger.error("发送短信失败");
        }


    }
}
