package com.yunque.www.springbootdemo.module.mysql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created on 2019/9/23 19:08
 * author:crs
 * Description:自动生成刷sql数据的脚本,
 */
public class MysqlController {

    public static void main(String[] args) throws Exception {
        //String sql = "select * from p_doctor where 1=1 limit %s ,%s";

        /*
        清除所有账户id
        String sql = "update p_doctor set acct_id=null where id between %s and %s";
        */

        // 更新账户id
        String sql = "update p_doctor pd inner join (select id,mobile_phone from account_info) acct on acct.mobile_phone=pd.mobile_phone set pd.acct_id=acct.id where pd.id between %s and %s";


        //String sql = "update p_doctor pd inner join (select id,mobile_phone from account_info) acct on acct.mobile_phone=pd.mobile_phone set pd.acct_id=acct.id where pd.id between %s and %s";


        //写入到某个文件里面
        File file = new File("D:\\UpdateSql.txt");
        Integer min = 99800000;
        Integer max = 101800000;
        System.out.println("数据区间："+(101800000-99800000));
        //file：要写入数据的 File 对象。FileWriter字符流，以字符的方式向文件中写入数据。
        //BufferedWriter:字符缓冲输出流
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        //i表示记录id
        for (int i = min; i <= max; i += 200000) {
            int nowIndex = i + 1;// 当前
            int endIndex = i + 200000; // 最大
            if (nowIndex > max) {
                continue;
            }
            System.out.println(nowIndex);
            System.out.println(endIndex);
            System.out.println("===============");
            out.write(String.format(sql, nowIndex, endIndex));  //写入字符串
            //写入一个行分隔符。 相当于换行。
            out.newLine();
        }
        out.flush();
        // 最后关闭流
        out.close();
    }
}
