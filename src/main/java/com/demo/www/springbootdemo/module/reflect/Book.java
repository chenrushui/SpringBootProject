package com.demo.www.springbootdemo.module.reflect;


public class Book {
    private final static String TAG = "BookTag";
    private String name;
    private String author;

    public Book() {
    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 声明了一个方法
     *
     * @param index
     * @return
     */
    private String declaredMethod(int index) {
        String str = null;
        switch (index) {
            case 0:
                str = "I am declaredMethod 1 !";
                break;
            case 1:
                str = "I am declaredMethod 2 !";
                break;
            default:
                str = "I am declaredMethod 1!";


        }
        return str;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
