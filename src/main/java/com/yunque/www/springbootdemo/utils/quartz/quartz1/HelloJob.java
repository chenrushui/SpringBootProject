//package com.yunque.www.springbootdemo.utils.quartz.quartz1;
//
//import org.quartz.*;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Created on 2019/4/18.
// * author:crs
// * Description:HelloJob
// */
//public class HelloJob implements Job {
//
//    private String message;
//    private float FloatJobValue;
//    private double doubleTriggerValue;
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        //处理具体的业务逻辑
//        //todo：把当前系统时间格式化，返回指定格式的字符串。
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        //System.out.println("hello world"+"当前时间"+format.format(date));
//        //todo:JobDetail类
//        //todo:JobDataMap类
//        JobDetail jobDetail = context.getJobDetail();
//        JobKey jobKey = jobDetail.getKey();
//        //System.out.println(jobKey.getName() + "---job名称和组---" + jobKey.getGroup());
//
//        TriggerKey triggerKey = context.getTrigger().getKey();
//        //System.out.println(triggerKey.getName() + "---trigger名称和组---" + triggerKey.getGroup());
//
//        //todo：如何获取传递的参数？
//        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
//        //String message = jobDataMap.getString("message");
//        //Float floatJobValue = jobDataMap.getFloat("FloatJobValue");
//        //System.out.println("获取job传入的参数"+message + "----"+ floatJobValue);
//
//        //JobDataMap jobTriggerDataMap = context.getTrigger().getJobDataMap();
//        //String triggerMessage = jobTriggerDataMap.getString("message");
//        //double doubleTriggerValue = jobTriggerDataMap.getDouble("doubleTriggerValue");
//        //System.out.println("获取Trigger传入的参数" +triggerMessage + "----"+ doubleTriggerValue);
//
//        //todo：会出现结果覆盖
//        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
//        //String message = mergedJobDataMap.getString("message");
//        //System.out.println(message);
//
//        System.out.println(message);
//        System.out.println(FloatJobValue);
//        System.out.println(doubleTriggerValue);
//
//        //todo：常用类JobDataMap、JobDetail、JobExecutionContext、rigger、Job、Date、SimpleDateFormat(格式)
//        //todo: quartz如何与Spring Boot进行整合？
//        //todo：获取常用类JobDataMap的两种方式
//
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public float getFloatJobValue() {
//        return FloatJobValue;
//    }
//
//    public void setFloatJobValue(float floatJobValue) {
//        FloatJobValue = floatJobValue;
//    }
//
//    public double getDoubleTriggerValue() {
//        return doubleTriggerValue;
//    }
//
//    public void setDoubleTriggerValue(double doubleTriggerValue) {
//        this.doubleTriggerValue = doubleTriggerValue;
//    }
//}
