package com.yunque.www.springbootdemo.pojo;

import com.yunque.www.springbootdemo.base.BaseDto;

public class DoctorDto extends BaseDto {

    //用户头像
    private String imageUrl;

    public String getImageUrl() {
        //todo：在这里处理图片地址
        return super.getUrl(imageUrl);
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
