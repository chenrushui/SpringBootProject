package com.demo.www.springbootdemo.crs.chain;

public class FirstFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.requestStr.replace("testMsg", "crs");
        System.out.println("First Request Filter str:" + request.requestStr);
        chain.doFilter(request, response, chain);
        //response.responseStr = response.responseStr + "-------------First response filter";
        //System.out.println("First Filter response Str:" + response.responseStr);

    }
}
