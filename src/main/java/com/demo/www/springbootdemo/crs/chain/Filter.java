package com.demo.www.springbootdemo.crs.chain;

public interface Filter {

    void doFilter(Request request, Response response, FilterChain chain);
}
