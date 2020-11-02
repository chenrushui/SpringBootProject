package com.demo.www.springbootdemo.crs.design.chain;

public class SecondFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.requestStr + "---------------Second request Filter";
        System.out.println("SecondFilter request str:" + request.requestStr);
        chain.doFilter(request, response, chain);
        //response.responseStr = response.responseStr;
        //System.out.println("SecondFilter response str:" + response.responseStr);
    }

}
