package com.yunque.www.springbootdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration //感觉此注解不需要
public class PropertiesConfiguration {

//    @Value("${sevenNiuFileUrl}")
    private String sevenNiuFileUrl="";

//    @Value("${ossFileUrl}")
    private String ossFileUrl="";

    public String getSevenNiuFileUrl() {
        return sevenNiuFileUrl;
    }

    public void setSevenNiuFileUrl(String sevenNiuFileUrl) {
        this.sevenNiuFileUrl = sevenNiuFileUrl;
    }

    public String getOssFileUrl() {
        return ossFileUrl;
    }

    public void setOssFileUrl(String ossFileUrl) {
        this.ossFileUrl = ossFileUrl;
    }
}
