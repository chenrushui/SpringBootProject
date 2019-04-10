package com.yunque.www.springbootdemo;

import com.yunque.www.springbootdemo.aop.MyAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//@ImportResource(locations = {"classpath:bean.xml"})
//@EnableRabbit
@EnableFeignClients
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

    {
        ArrayList<String> params=new ArrayList<>();
        params.forEach((String hospitalId) -> {
            //List<DoctorMemberDto> memberList = hospitalDepartmentService.getHospitalDepartmentMembersInfo(hospitalId);

        });
        params.forEach(new Consumer<String>() {
            @Override
            public void accept(String hospitalId) {
                //List<DoctorMemberDto> memberList = hospitalDepartmentService.getHospitalDepartmentMembersInfo(hospitalId)
            }
        });
    }


}
