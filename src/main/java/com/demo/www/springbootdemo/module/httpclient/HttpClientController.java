package com.demo.www.springbootdemo.module.httpclient;

import com.demo.www.springbootdemo.exceptions.demo.BaseResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * Created on 2020/4/13 16:22
 * author:crs
 * Description:HttpClient的使用封装
 */
@RestController
public class HttpClientController {

    private String request_url = "";

    @GetMapping("/get")
    public BaseResponse testGetRequest() throws IOException {

        //处理请求头
        //处理请求体
        String url = "";
        List<NameValuePair> parmas = new ArrayList<>();
        parmas.add(new BasicNameValuePair("name", "crs"));
        HttpClient httpClient = new DefaultHttpClient();
        processHeader(httpClient);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(parmas, "UTF8"));
        HttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == 200) {

        }

        return BaseResponse.toResponse();
    }

    //处理公共请求头信息
    private void processHeader(HttpClient httpClient) {

    }


    //get请求，无参数
    public void doGetTestOne() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(request_url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            //响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                System.out.println("响应内容长度为:" + entity.getContentLength());
                //把HttpEntity转化成json字符串
                System.out.println("响应内容为:" + EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doGetTestWayOne() throws UnsupportedEncodingException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //参数
        StringBuffer params = new StringBuffer();
        params.append("name=" + URLEncoder.encode("&", "utf-8"));
        params.append("&");
        params.append("age=24");


    }


}
