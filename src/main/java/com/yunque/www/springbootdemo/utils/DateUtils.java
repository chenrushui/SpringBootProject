package com.yunque.www.springbootdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class DateUtils {

    public void getDate() {
        //当前系统时间的毫秒值
        //Date类型转成long类型
        long time = new Date().getTime();
    }


    /**
     * 获取两个时间之间的和
     *
     * @param date
     * @param millsTime
     * @return
     */
    public static Date addDateSeconds(Date date, long millsTime) {
        Date result = new Date(date.getTime() + millsTime);
        return result;
    }

    /**
     * 比较两个时间之间的差值
     *
     * @param dateOld 当前时间
     * @param dataNew 过期时间
     * @return
     */
    public static int daysBetween(Date dateOld, Date dataNew) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = format.parse(format.format(dateOld));
        Date parse2 = format.parse(format.format(dataNew));
        //todo:使用默认时区和语言环境获得一个日历
        Calendar instance = Calendar.getInstance();
        //设置时间
        instance.setTime(parse1);
        //java.util.Calendar.getTimeInMillis() 方法返回此Calendar以毫秒为单位的时间
        long timeInMillis = instance.getTimeInMillis();
        instance.setTime(parse2);
        long timeInMillis1 = instance.getTimeInMillis();
        long dayNum = (timeInMillis1 - timeInMillis) / 86400000L;
        return (int) dayNum;
    }

    /**
     * 计算两个时间之间相差多少小时
     *
     * @param date_from
     * @param date_to
     * @return
     */
    public static int getDistanceHours(Date date_from, Date date_to) {
        int hours = 0;
        //todo:判断两个时间的先后，boolean类型
        if (date_from.before(date_to)) {
            hours = (int) ((date_to.getTime() - date_from.getTime()) / 3600000);
        }
        return hours;

    }

    public static void main(String[] args) throws ParseException {
        //Date date = DateUtils.addDateSeconds(new Date(), 15 * 24 * 60 * 60 * 1000L);
        //日期格式不能错，否则得不到正确的时间
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String data = format.format(date);
        //System.out.println(data);
        //int i = DateUtils.daysBetween(new Date(), new Date(System.currentTimeMillis() + 1000000000));
        //System.out.println(i);
        //int distanceHours = DateUtils.getDistanceHours(new Date(),new Date(System.currentTimeMillis()+3700000));
        //System.out.println(distanceHours);

        System.out.println(UUID.randomUUID().toString().replace("_", "").length());
    }
}
