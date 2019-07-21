package com.scott.java.task.instanceoftest;

import java.util.List;


public class InstanceOfTest {


    public static void main(String[] args) {
        String [] stringArray = new String[]{};
        String text = "我是字符串";
        B[] bArray = new B[]{};
        B b = new B();
        A ab = new B();
        System.out.println("class instanceof test");
        System.out.println(b instanceof A);
        System.out.println(b instanceof B);
        System.out.println(b instanceof C);
        System.out.println(ab instanceof A);
        System.out.println(ab instanceof B);
        System.out.println(ab instanceof C);
        System.out.println(null instanceof Object);
        System.out.println(text instanceof String);

        System.out.println("interface instanceof test");
        System.out.println(b instanceof B);
        System.out.println(b instanceof C);
        System.out.println(b instanceof D);
        System.out.println(ab instanceof B);
        System.out.println(ab instanceof C);
        System.out.println(ab instanceof D);


        System.out.println("array instanceof test");
        System.out.println(b instanceof List);
        System.out.println(bArray instanceof A[]);
        System.out.println(bArray instanceof B[]);
        System.out.println(bArray instanceof C[]);
        System.out.println(bArray instanceof D[]);
        System.out.println(stringArray instanceof String[]);

    }
}

class B extends A implements C {

}

class A {

}

interface C extends D {

}

interface D {

}