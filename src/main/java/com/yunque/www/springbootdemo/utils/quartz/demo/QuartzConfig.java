//package com.yunque.www.springbootdemo.utils.quartz.demo;
//
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created on 2019/4/22.
// * author:crs
// * Description:定时任务配置类
// */
//@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail testJobTask1() {
//        return JobBuilder.newJob(JobTask1.class).withIdentity("JobTask1").build();
//    }
//
//    @Bean
//    public Trigger testQuartzTrigger() {
//        return TriggerBuilder.newTrigger()
//                .forJob(testJobTask1())
//                .withIdentity("TriggerTask1")
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
//                .build();
//    }
//
//    @Bean
//    public JobDetail testJobTask2() {
//        return JobBuilder.newJob(JobTask2.class).withIdentity("JobTask2").build();
//    }
//
//    @Bean
//    public Trigger testQuartzTrigger2() {
//        //cron方式，每隔5秒执行一次
//        return TriggerBuilder.newTrigger().forJob(testJobTask2())
//                .withIdentity("testTask2")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
//                .build();
//    }
//}
