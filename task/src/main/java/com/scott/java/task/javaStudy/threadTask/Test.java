package com.scott.java.task.javaStudy.threadTask;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
        protected Long initialValue() {
            return Thread.currentThread().getId();
        };
    };
    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){
        protected String initialValue() {
            return Thread.currentThread().getName();
        };
    };


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();

        test.set();
        System.out.println("当前线程是" + test.getString() + "," +test.getLong());



        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());

//        Father father = new Father(){
//            public Collection doSth(Map map) {
//                System.out.println("复写方法");
//                return map.values();
//            }
//        };
//        Map map = new HashMap();
//        father.doSth(map);
    }
}