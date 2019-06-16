package com.scott.java.task.reflect;

import java.lang.reflect.Method;

/**
 * @author scott
 * @date 2019/1/24 13:31
 */

public class ReflectTest2 {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.scott.java.task.reflect.ReflectTest2");
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }

    /**
     * 0-15都是调用的 NativeMethodAccessorImpl.invoke0  16次开始调用at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
     * java.lang.Exception: #15
     * 	at com.scott.java.task.reflect.ReflectTest2.target(ReflectTest2.java:12)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at com.scott.java.task.reflect.ReflectTest2.main(ReflectTest2.java:19)
     * java.lang.Exception: #16
     * 	at com.scott.java.task.reflect.ReflectTest2.target(ReflectTest2.java:12)
     * 	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at com.scott.java.task.reflect.ReflectTest2.main(ReflectTest2.java:19)
     *
     * 	如果设置-Dsun.reflect.noInflation=true 从第一次就是调用java 版的invoke
     *  java.lang.Exception: #0
     * 	at com.scott.java.task.reflect.ReflectTest2.target(ReflectTest2.java:12)
     * 	at sun.reflect.GeneratedMethodAccessor2.invoke(Unknown Source)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at com.scott.java.task.reflect.ReflectTest2.main(ReflectTest2.java:19)
     *
     */

}

