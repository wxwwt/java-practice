package com.scott.java.task.reflect;


import java.lang.reflect.Method;

/**
 * @author scott
 * @date 2019/1/22 20:04
 */

public class ReflectTest1 {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = ReflectTest1.class;
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }

 /*使用的是Java 8, 单次调用反射的结果 是使用的本地实现
    java.lang.Exception: #0
	at com.scott.java.task.reflect.ReflectTest1.target(ReflectTest1.java:14)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.scott.java.task.reflect.ReflectTest1.main(ReflectTest1.java:20)
*/

}
