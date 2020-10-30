package com.demo.www.springbootdemo.crs.chain;

public class MainTest {
    public static void main(String[] args) {
        String msg = "testMsg";
        Request request = new Request();
        request.requestStr = msg;
        Response response = new Response();
        response.responseStr = "responseStr";

        //1，创建一个责任链
        FilterChain fc = new FilterChain();
        //2，把这两个节点添加到链条中，顺序添加
        fc.addFilter(new FirstFilter()).addFilter(new SecondFilter());
        //3，同一个请求在两个节点之间传递
        fc.doFilter(request, response, fc);
    }
}
