package com.demo.www.springbootdemo.module.reference;

/**
 * Created on 2020/4/23 18:00
 * author:crs
 * Description:测试值类型与引用类型
 */
public class TestReference {

    public static void main(String[] args) {

        //Integer i = new Integer(5);
        //System.out.println(i.hashCode());

        //int j = 5;
        //System.out.println(j.hashCode());
        //不能对基本类型调用方法，但可以对引用类型调用方法：

        /*
        Integer a = 120;
        int b= 120;
        Integer c = 120;
        Integer d = new Integer(120);
        System.out.println(a == b);   //产生的原因是编译器编译时会调用intValue()自动的将a进行了拆箱，结果肯定是true;
        System.out.println(a == c);   //true  jdk对-128~127之间的值做了缓存。
        System.out.println(a == d);   //false  new Integer(120)构造器会创建新的对象。

        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f);  //false  大于128 使用==比较，不相等。
        */

        /*
        int n=3;
        int m=3;
        System.out.println(n==m); //直接比较值

        String str = new String("hello");
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1==str2); //两个对象

        str1 = str;
        str2 = str;
        System.out.println(str1==str2); //指向了同一个引用
        */

        /*
        boolean b = false; //值传递
        Boolean boo = new Boolean(false);//包装类因为会自动装箱拆箱，所以可以和基本类型一样处理，所以示例中boo的值就是false；
        Boolean[] arr = new Boolean[]{false}; // 数组是引用类型，所以arr的值就是指向该Boolean[]的引用。
        //java中只有值传递没有引用传递，所以传入getMiddleOne方法的三个参数分别是b的值拷贝, boo的值拷贝, arr的值拷贝。
        //java中只有值传递，基本类型传递的是值的副本，引用类型传递的是引用的副本。
        getMiddleOne(b, boo, arr);

        System.out.println(b);
        System.out.println(boo.toString());
        System.out.println(arr[0]);  //arr的值就是指向该Boolean[]的引用。
        */

    }

    private static void getMiddleOne(boolean b, Boolean boo, Boolean[] arr) {
        b = true;
        boo = new Boolean(true);
        arr[0] = true;
    }

}
