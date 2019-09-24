package com.demo.www.springbootdemo.module.stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 2019/9/24 14:56
 * author:crs
 * Description:字符缓冲输出流
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        //操作字符，写数据，刷缓存，关闭流
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\1.txt"));
        bw.write("crs");
        bw.newLine();
        bw.write("crs1");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
