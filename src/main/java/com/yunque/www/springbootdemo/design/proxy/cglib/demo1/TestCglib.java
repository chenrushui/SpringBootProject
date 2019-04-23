package com.yunque.www.springbootdemo.design.proxy.cglib.demo1;

import com.bumptech.glide.Glide;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:TestCglib
 */
public class TestCglib {
    public static void main(String[] args) {
        ProxyLogic proxyLogic = new ProxyLogic();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonProxy.class);
        enhancer.setCallback(proxyLogic);

        //获取代理对象
        PersonProxy personProxy = (PersonProxy) enhancer.create();
        personProxy.say();

        //todo:如何对这个进行封装增强？
        //todo:对某个类生成代理类： 比如图片加载框架，如何实现？用于增强方法的功能。二次封装。图片框架的封装
        enhancerGlide();
    }

    private static void enhancerGlide() {
        //Context context;
        //Glide.with(context).load(url).into(imageView);
        //Glide glide = Glide.get(context);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Glide.class);
        enhancer.setCallback(new GlideProxy());
    }
}
