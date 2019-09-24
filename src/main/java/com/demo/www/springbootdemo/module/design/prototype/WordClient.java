package com.demo.www.springbootdemo.module.design.prototype;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:WordClient，通过复制生成实例
 */
public class WordClient {

    public static void main(String[] args) {
        //旧的对象
        WordDocument wordDocument = new WordDocument();
        wordDocument.setTxt("这是一篇文档");
        wordDocument.setImages("图片1");
        wordDocument.setImages("图片2");
        wordDocument.setImages("图片3");
        wordDocument.showDocument();


        //新对象,以当前对象为原型，拷贝一份副本
        WordDocument newObject = wordDocument.clone();
        newObject.showDocument();
        //修改副本，不会影响原始对象
        newObject.setTxt("这是新对象");
        newObject.setImages("新图片");
        newObject.showDocument();

        //再次打印原始对象的信息
        wordDocument.showDocument();
    }
}
