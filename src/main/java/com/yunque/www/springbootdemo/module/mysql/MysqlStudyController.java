package com.yunque.www.springbootdemo.module.mysql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 2019/9/24 10:18
 * author:crs
 * Description:批量生成
 */
public class MysqlStudyController {

    public static void main(String[] args) throws IOException {
        String sql = "select * from p_doctor where id between  %s and %s";

        //文件存储的位置
        File file = new File("D:\\UpdateSql.txt");
        //输出流，把内容写入到文件中
        FileWriter fileWriter = new FileWriter(file);
        //文件输出流
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        int min = 0;
        int max = 1000000;
        //每次进行一万次的累加
        for (int i = min; i < max; i += 100000) {
            int nowIndex = i+1;
            int lastIndex = i + 100000;
            if (nowIndex > lastIndex) {
                continue;
            }
            System.out.println(nowIndex);
            System.out.println(lastIndex);
            System.out.println("----------------");
            bufferedWriter.write(String.format(sql, nowIndex, lastIndex));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
