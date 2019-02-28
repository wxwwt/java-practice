package com.scott.java.task.string;

public class StringTest {

    public static void main(String[] args)
    {
        String s1 = "HelloWorld";
        String s2 = new String("HelloWorld");
        String s3 = new String("HelloWorld");
        int i1 = 1;
        Integer i2 = 1;
        Integer i3 = new Integer(1);
//        String s3 = "Hello";
//        String s4 = "World";
//        String s5 = "Hello" + "World";
//        String s6 = s3 + s4;
//
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s5);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s6.intern());
//        System.out.println(s2 == s2.intern());
//
//        System.out.println(s2 == s7);
//
//        System.out.println();
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s2.intern()));
        System.out.println(System.identityHashCode(s3.intern()));


        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));
        System.out.println(System.identityHashCode(i3));

    }

}
