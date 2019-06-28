package com.yunque.www.springbootdemo.utils.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * Created on 2019/3/20.
 * author:crs
 * Description:MyTimerTask
 */
public class MyTimerTask extends TimerTask {
    private String name;
    private int count = 0;

    public MyTimerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (count < 100) {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = simpleDateFormat.format(instance.getTime());
            System.out.println(name + "----->" + time);
        } else {
            cancel();
        }
        count++;
    }
}
