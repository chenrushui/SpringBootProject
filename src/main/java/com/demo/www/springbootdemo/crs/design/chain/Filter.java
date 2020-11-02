package com.demo.www.springbootdemo.crs.design.chain;

public interface Filter {

    void doFilter(Request request, Response response, FilterChain chain);
}
