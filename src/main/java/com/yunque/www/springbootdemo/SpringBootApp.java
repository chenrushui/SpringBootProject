package com.yunque.www.springbootdemo;

import com.yunque.www.springbootdemo.aop.MyAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@ImportResource(locations = {"classpath:bean.xml"})
//@EnableRabbit
@MapperScan(basePackages = "com.yunque.www.springbootdemo.mapper")
@SpringBootApplication(scanBasePackages = "com.yunque.www")
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    /**
     * 如果不注入到容器中，就不能发挥作用
     *
     * @return
     */
    @Bean(name = "myAspect")
    public MyAspect getMyAspect() {
        return new MyAspect();
    }
}
