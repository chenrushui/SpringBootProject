package com.demo.www.springbootdemo;

import com.demo.www.springbootdemo.module.anno.demo1.TestParamLog;
import com.demo.www.springbootdemo.module.aop.MyAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

//@ImportResource(locations = {"classpath:bean.xml"})
@EnableRabbit
//@EnableFeignClients
@EnableScheduling
@MapperScan(basePackages = "com.demo.www.springbootdemo.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBootApp {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx =   SpringApplication.run(SpringBootApp.class, args);

        System.out.println(new TestParamLog().addSum(1, 2));

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        template.convertAndSend("chat", "Hello from Redis!");
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
        ArrayList<String> params = new ArrayList<>();
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

    /**
     * 让容器帮我们实例化此对象
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
