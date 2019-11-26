package com.demo.www.springbootdemo.module.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created on 2019/11/20 17:03
 * author:crs
 * Description:文件操作
 */
public class TestFile1 {

    public static void main(String[] args) throws IOException {
        MultipartFile files=null;
        //获取原文件名
        String filename = files.getOriginalFilename();
        //项目路径
        String updateFolder= System.getProperty("user.dir");
        File newFile = new File(updateFolder, filename);
        if (!newFile.getParentFile().exists()){

            newFile.getParentFile().mkdir();
            //File类中的mkdir()和mkdirs(),  mkdir()：只能创建一层目录.  mkdirs()：可以创建多层目录
            //mkdirs()  创建多级文件夹。
            //一个文件File实例，指向一个文件夹活着文件。
            //获取当前文件的父文件。
            //通过路径和文件名称，创建一个文件。
            //获取文件的名称。
        }
        //把文件存储到文件夹里面去
        files.transferTo(newFile);

        //通过单路径创建文件
        //String path="/usr/sunny/images/product/img/";
        //File file = new File(path);

        //file.isDirectory() 判断当前文件是否是文件夹？
    }
}
