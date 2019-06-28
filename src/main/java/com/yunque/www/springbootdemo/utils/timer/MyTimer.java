package com.yunque.www.springbootdemo.utils.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created on 2019/3/20.
 * author:crs
 * Description:XXX
 */
public class MyTimer {


    public static void main(String[] args) {
        Timer myTimer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask("无极天下");
        //通过timer定时定频率调用myTimerTask中的业务逻辑方法。
        //第一次执行是在当前时间的两秒以后执行，之后每隔秒执行一次
        //myTimer.schedule(myTimerTask,2000,1000);

        //参数含义：
        //要执行的任务，首次执行任务的时间，执行一次task的时间间隔，执行任务前的延时时间(单位是毫秒)
        //等待delay毫秒后执行仅切执行一次
        //当前任务是否需要循环执行
        //cancel()取消当前TimerTask里面的任务
        //一个任务，只希望它执行三次？如何处理？使用计时器
        //cancel():终止此计时器，丢弃所有当前已安排的任务
        //purge():返回从任务队列中取消的任务数(每个TimerTask算一个任务)


        //如何获取当前的时间？
        Calendar calendar = Calendar.getInstance();
        //如何格式化时间？
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间：" + simpleDateFormat.format(calendar.getTime()));
        //如何为当前时间添加三秒钟
        //calendar.add(Calendar.SECOND,3);
        //myTimer.schedule(myTimerTask,calendar.getTime());
        //myTimer.schedule(myTimerTask,calendar.getTime(),3000);
        //myTimer.schedule(myTimerTask,1000);
        myTimer.schedule(myTimerTask, 1000, 1000);
        try {
            Thread.sleep(5000);
            myTimer.cancel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(simpleDateFormat.format(myTimerTask.scheduledExecutionTime()));

    }
}
