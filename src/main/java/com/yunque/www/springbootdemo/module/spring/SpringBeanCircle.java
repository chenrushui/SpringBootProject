package com.yunque.www.springbootdemo.module.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:SpringBean生命周期
 * todo：可以感知到自己的某一个属性
 */
@Slf4j
@Component
public class SpringBeanCircle implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String name;

    public SpringBeanCircle() {
        log.info("第一步：初始化...");
    }

    public void setName(String name) {
        this.name = name;
        log.info("第二步：设置属性");
    }

    /**
     * 设置beanId，对象的名称
     *
     * @param objectName
     */
    @Override
    public void setBeanName(String objectName) {
        log.info("第三步：设置Bean的名称" + objectName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("第四步：了解工厂信息");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("第六步：属性设置后");
    }

    public void setup() {
        log.info("第七步：MAN被初始化了...");
    }

    public void run() {
        log.info("第九步：执行业务方法");
    }

    @Override
    public void destroy() throws Exception {
        log.info("第十步：执行Spring的对象销毁方法");
    }

}
