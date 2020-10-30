package com.demo.www.springbootdemo.utils;

import com.demo.www.springbootdemo.config.PropertiesConfiguration;
import com.demo.www.springbootdemo.pojo.DoctorDto;
import com.demo.www.springbootdemo.pojo.BaseResult;
import com.demo.www.springbootdemo.pojo.Doctor;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 跨服务调用
 */
@Component
public class RestUtils {

//    @Autowired
//    private RestTemplate restTemplate;

    public ResponseEntity<BaseResult<List<Doctor>>> getRemoteData(String url) {
        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.add("version", "version");
        headers.add("token", "token");
        //请求实体
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        process(httpEntity);
        //返回数据模型的泛型类型
        ParameterizedTypeReference<BaseResult<List<Doctor>>> classType = new ParameterizedTypeReference<BaseResult<List<Doctor>>>() {
        };
        //ResponseEntity<BaseResult<List<Doctor>>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, classType, new HashMap<>());
        //不能传递请求头，具备局限性
        //Object forObject = restTemplate.getForObject();
        //return responseEntity;
        return null;
    }

    @GetMapping("/")
    public void getHttpData(HttpServletResponse response) throws IOException {
        response.setHeader("token", "token");
        response.setStatus(200);
        response.getWriter().write("success");
    }

    private void process(HttpEntity<String> httpEntity) {
        System.out.println(httpEntity.getBody());
        System.out.println(httpEntity.getHeaders());


        //HttpStatus:请求状态
        //ResponseEntity:请求响应
        ResponseEntity<String> responseEntity = new ResponseEntity<>("success", HttpStatus.OK);
        //为ResponseEntity设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", "token");
        new ResponseEntity<>("success", headers, HttpStatus.OK);

        //构建者模式
        //ResponseEntity作为响应对象
        ResponseEntity.ok("Hello World!");
        ResponseEntity.ok().header("token", "token").body("success");
    }


    {
        StringUtils.isBlank("");

    }

    /**
     * 通用地址头处理
     */
    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    public void processImageUrl(){
        DoctorDto doctorDto = new DoctorDto();
        //仅仅是把父地址传递进去，不需要这样处理。
        doctorDto.setUrlHead(propertiesConfiguration.getOssFileUrl(), propertiesConfiguration.getSevenNiuFileUrl());
        //思路：
        //1)把地址配置到properties中，动态可配置,
        //2)通过value给变量赋值并进行实例化,
        //3)调用方法处理图片地址头。  每次后端返回前端url都会这样处理。
        //4)BaseDto里面封装了通用的拼接逻辑，供子dto调用。

        //1)不一定要这样用，BaseDto里面获取父地址，并提供拼接方法，
        //2)json序列化的时候会调用get
        // 方法，get方法调用弄给父类中的方法拼接数据

    }


}
