//package com.yunque.www.springbootdemo.utils.quartz.demo;
//
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Created on 2019/4/22.
// * author:crs
// * Description:定时任务2
// */
//public class JobTask2 extends QuartzJobBean {
//    @Override
//    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("JobTask2---"+format.format(new Date()));
//    }
//}
