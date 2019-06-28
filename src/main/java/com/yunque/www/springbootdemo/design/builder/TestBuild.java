package com.yunque.www.springbootdemo.design.builder;

/**
 * Created on 2018/10/10.
 * Author:crs
 * Description:主要用于测试build模式:建造者模式
 */
public class TestBuild {
    public static void main(String[] args) {

        //创建各种所需的对象
        //Person person = new Person();
        //Person person1 = new Person("crs");
        //Person person2 = new Person("crs",21);

        //创建静态内部类的对象
        Person.Builder builder = new Person.Builder();
        //把数据先存放到Builder类的成员变量中，等到bulid Person对象的时候，在给person对象赋值。
        Person person = builder.name("crs").age(21).height(179).weight(12).create();
        System.out.println(person.toString());

        //对象有很多属性值，创建对象的时候，可以允许有些属性值不被设置，可以为null。换种说法就是创建对象的时候，有些参数可能不传递。
        //那这就要求这个对象的使用比较灵活，不一定是标准化的。

        //1）后面两个参数是什么含义，应该传递什么值？
        //2）如果有很多参数时，编写这个构造函数就会显得异常麻烦(Dialog类的使用)。

        /**
         * 建造者模式：
         * 通过静态内部类实现：Builder；
         * 构造函数的入参是Builder对象，然后依次对自己的成员变量进行赋值，对应的值都是Builder对象中的值(外层类创建的时候，属性由Builder对象进行赋值；)
         * 修改外层类的构造方法（Builder builder）；
         *
         * 在Builder类里定义了一份与外层类一模一样的变量，通过一系列的成员函数对属性进行设置值；
         * 返回值都是this，也就是Builder对象本身；
         * 最后提供一个build方法用于创建外层类的对象，返回值为外层类的对象；
         * Builder类中的成员函数返回Builder对象自身的另一个作用就是让它支持链式调用，使代码可读性大大增强；
         *
         * 静态内部类特征：
         * 静态类不用先创建外部类。可以静态类看做外部类的静态变量，使用就不要外部类实例；而非静态就必须先实例化。
         * 创建静态内部类对象的标准写法：new OuterClass.NestedStaticClass()
         *
         * 总结：
         * 定义一个静态内部类Builder，内部的成员变量和外部类一样
         * Builder类通过一系列的方法用于成员变量的赋值，并返回当前对象本身（this）
         * Builder类提供一个build方法或者create方法用于创建对应的外部类对象，该方法内部调用了外部类的一个私有构造函数，该构造函数的参数就是内部类Builder
         * 外部类提供一个私有构造函数供内部类调用，在该构造函数中完成成员变量的赋值，取值为Builder对象中对应的值
         */

        //对话框的创建，就是用了建造者模式
        //AlertDialog类中有静态内部类Builder，内部提供了create()方法返回值为AlertDialog。
        //createDialog();

        //Gson中的GsonBuilder也是建造者模式
        //createGson();

        //网络请求框架OkHttp,Request网络请求对象的创建
        //Response对象也是通过建造者模式进行创建的。
        //createOKHttp();

        //EventBus中也有一个Builder，只不过这个Builder外部访问不到而已，
        //因为它的构造函数不是public的，但是你可以在EventBus这个类中看到他的应用（建造者模式）。

        //testTeacherBuilder();
    }

//    private static void testTeacherBuilder() {
//        Teacher.Builder builder = new Teacher.Builder();
//        Teacher teacher = builder.setName("陈如水").setAge(21).create();
//        String result = teacher.getName() + "" + teacher.getAge();
//    }

//    private static void createOKHttp() {
//        //里面有静态内部类Builder，网络请求是多变的，每个网络请求可能都不一样，但是项目里面需要有多个网路请求对象。
//        Request.Builder builder = new Request.Builder();
//        Request request = builder.addHeader("", "")
//                .url("")
//                .get()
//                .build();
//    }

//    private static void createGson() {
//        //GsonBuilder对象
//        GsonBuilder builder = new GsonBuilder();
//        //GsonBuilder内部提供了create()方法，已经看过源码
//        Gson gson = builder.setPrettyPrinting()
//                .disableHtmlEscaping()
//                .serializeNulls()
//                .create();
//    }

//    private static void createDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(ContextUtil.getContext());
//        AlertDialog dialog = builder.setTitle("标题").setIcon(R.mipmap.ic_launcher).setCancelable(true).setPositiveButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        }).create();
//        dialog.show();
//    }
//}
}
