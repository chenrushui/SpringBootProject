package com.demo.www.springbootdemo.utils.encry;

import java.security.MessageDigest;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:MD5Utils1
 */
public class MD5Utils1 {
    public static String stringToMD5(String str) {
        //MessageDigest 类为应用程序提供信息摘要算法的功能.
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }

        //获取字符数组
        char[] charsArray = str.toCharArray();
        //获取字节数组：todo：每一次字符都对应不同的ASCII码
        byte[] bytesArray = new byte[charsArray.length];
        for (int i = 0; i < charsArray.length; i++) {
            //把字符数组转化成字节数组
            bytesArray[i] = (byte) charsArray[i];
        }
        //进行哈希计算
        byte[] md5Bytes = md5.digest(bytesArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            //todo：位运算
            int value = ((int) md5Bytes[i]) & 0xff;
            if (value < 16) {
                hexValue.append("0");
            }
            //todo:把十进制int类型转化成十六进制
            hexValue.append(Integer.toHexString(value));
        }
        return hexValue.toString();
    }

    public static void main(String[] args) {
        String result = MD5Utils1.stringToMD5("13024112588");
        System.out.println(result);
    }

}
