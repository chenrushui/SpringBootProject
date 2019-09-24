//package com.yunque.www.springbootdemo.utils.quartz.quartz1;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
///**
// * Created on 2019/4/18.
// * author:crs
// * Description:调度器
// */
//public class HelloSchedule {
//
//    public static void main(String[] args) throws SchedulerException {
//
//
//        //todo:如何获取JobDetail实例？
//        //创建一个JobDetail实例，然后和具体的Job进行绑定。
//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("myJob", "group1")
//                .usingJobData("message", "hello myJob1") //传入参数
//                .usingJobData("FloatJobValue", 5.5f)
//                .build();
//        System.out.println("jobDetail---->" + jobDetail.getKey().getName());
//        System.out.println("jobDetail---->" + jobDetail.getKey().getGroup());
//        System.out.println("jobDetail---->" + jobDetail.getJobClass().getName());
//
//        //todo：如何获取Trigger实例？
//        //创建一个Trigger实例，定义该job立即执行，并且每个两秒钟执行一次。
//        //SimpleScheduleBuilder
//        //现在开始执行，执行频率
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("myTrigger", "group1")
//                .usingJobData("message",      "myTrigger1")
//                .usingJobData("doubleTriggerValue", 2.0d)
//                .startNow()
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(1))
//                .build();
//
//        //todo:如何获取scheduler实例？
//        //创建schedule实例
//        SchedulerFactory sf = new StdSchedulerFactory();
//        Scheduler scheduler = sf.getScheduler();
//        scheduler.start();
//        //todo：如何绑定jobDetail和trigger？
//        scheduler.scheduleJob(jobDetail, trigger);
//    }
//}
