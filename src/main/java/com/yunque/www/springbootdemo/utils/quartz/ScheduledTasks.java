package com.yunque.www.springbootdemo.utils.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created on 2019/4/22.
 * author:crs
 * Description:XXX
 */
@Slf4j
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //todo:在方法上加@Scheduled注解，表明该方法是一个调度任务方法，定时执行
    @Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime() {
        //log.info(dateFormat.format(new Date()));
        //System.out.println(dateFormat.format(new Date()));
    }
}
