//package com.yunque.www.springbootdemo.utils.quartz.quartz2;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//import java.util.Date;
//
///**
// * Created on 2019/4/22.
// * author:crs
// * Description:Cron表达式
// */
//public class CronExpress {
//
//    public static void main(String[] args) throws SchedulerException {
//        Date date = new Date();
//
//        //定义一个触发器
//        CronTrigger cronTrigger = (CronTrigger) TriggerBuilder
//                .newTrigger()
//                .withIdentity("myTrigger", "group1")
//                .withSchedule(CronScheduleBuilder.cronSchedule(""))
//                .startAt(date)
//                .endAt(date)
//                .build();
//
//        //todo：cron表达式的通配符
//        //todo：cron表达式在线生成器（特别好用）
//        //2017年内每天10点15分触发一次（七个符号）
//
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 15 10 ？* * 2017");
//
//        //获取工厂，获取调度器，调度器启动。关联Trigger与JobDetail
//        //todo：Scheduler的创建方式 StdSchedulerFactory
//        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = stdSchedulerFactory.getScheduler();
//        scheduler.start();
//        scheduler.scheduleJob(null,cronTrigger);
//        //shutDown()
//    }
//
//}
