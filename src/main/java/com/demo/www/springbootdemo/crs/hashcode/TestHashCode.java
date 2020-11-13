package com.demo.www.springbootdemo.crs.hashcode;

public class TestHashCode {
    public static void main(String[] args) {
        HashEntity hashEntity = new HashEntity();
        HashEntity hashEntity1 = new HashEntity();
        System.out.println(hashEntity.hashCode());
        System.out.println(hashEntity1.hashCode());

    }
}
