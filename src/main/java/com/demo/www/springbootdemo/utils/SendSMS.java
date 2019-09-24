package com.demo.www.springbootdemo.utils;

import com.demo.www.springbootdemo.utils.encry.MD5Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created on 2019/4/4.
 * author:crs
 * Description:SendSMS()
 */
public class SendSMS {

    /**
     * 美联软通短信平台
     * 1)把所有参数处理后放到StringBuffer中
     * 2)发送HttpURLConnection网络请求
     * 3)获取发送结果
     */
    public static void send() {
        //连接超时及读取超时设置
        System.setProperty("sun.net.client.defaultConnectTimeout", "30000"); //连接超时：30秒
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");    //读取超时：30秒

        //新建一个StringBuffer链接
        StringBuffer buffer = new StringBuffer();

        //String encode = "GBK"; //页面编码和短信内容编码为GBK。重要说明：如提交短信后收到乱码，请将GBK改
        //为UTF-8测试。如本程序页面为编码格式为：ASCII/GB2312/GBK则该处为GBK。如本页面编码为UTF-8或需要支持繁体，阿拉伯文等
        //Unicode，请将此处写为：UTF-8

        String encode = "UTF-8";
        //账号的用户名和密码；密码需要MD5加密
        String username = "13024112588";  //用户名
        String password_md5 = MD5Utils.string2MD5("qq123456");
        String mobile = "13024112588";  //手机号,只发一个号码：13800000001。发多个号码：13800000001,13800000002,...N。使用半角逗号分隔。
        //apikey秘钥（请登录 http://m.5c.com.cn 短信平台-->账号管理-->我的信息 中复制apikey）
        String apikey = "56ed2d7aeb8f0c14f8ffd244db29ebd1";
        String content = "您好，您的验证码是：12345【美联】";  //要发送的短信内容，特别注意：签名必须设置，网页验证码应用需要加添加【图形识别码】。

        String contentUrlEncode = null;
        try {
            //对短信内容做Urlencode编码操作。注意：如
            contentUrlEncode = URLEncoder.encode(content, encode);
            //把发送链接存入buffer中，如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
            buffer.append("http://115.28.23.78/api/send/index.php?username=" + username
                    + "&password_md5=" + password_md5 + "&mobile=" + mobile + "&apikey=" + apikey + "&content=" + contentUrlEncode
                    + "&encode=" + encode);
            //System.out.println(buffer); //调试功能，输入完整的请求URL地址
            //把buffer链接存入新建的URL中
            URL url = new URL(buffer.toString());
            //打开URL链接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //使用POST方式发送
            connection.setRequestMethod("POST");
            //使用长链接方式
            connection.setRequestProperty("Connection", "Keep-Alive");

            //发送短信内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            //获取返回值
            String result = reader.readLine();
            //输出result内容，查看返回值，成功为success，错误为error，详见该文档起始注释
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
