package com.demo.www.springbootdemo.module.design.prototype;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:WordDocument原型设计模式
 */
//todo:自己捕捉当前log所在的类，不需要自己进行过滤。info()方法只传入一个参数就好了。
@Slf4j
public class WordDocument implements Cloneable {

    private Logger log= LoggerFactory.getLogger(WordDocument.class);

    private String txt;
    private ArrayList<String> images = new ArrayList<>();

    public WordDocument() {
        log.info("WordDocument的构造函数");
    }

    /**
     * 这个方法并不是Cloneable接口中的，而是Object中的方法
     * 如果没有实现Cloneable接口却调用了clone()函数会报异常
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected WordDocument clone() {
        try {
            WordDocument wordDocument = (WordDocument) super.clone();
            wordDocument.txt = this.txt;
            //wordDocument.images = this.images;
            //对image对象也调用clone()函数，进行深拷贝(浅拷贝和深拷贝)
            wordDocument.images = (ArrayList<String>) this.images.clone();
            return wordDocument;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(String image) {
        this.images.add(image);
    }

    public void showDocument() {
        log.info(txt);
        log.info("Images List: ");
        for (String image : images) {
            log.info("image name: " + image);
        }
        log.info("------------------");
    }

    @Override
    public String toString() {
        return "WordDocument{" +
                "txt='" + txt + '\'' +
                ", images=" + images +
                '}';
    }
}
