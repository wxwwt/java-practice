package com.scott.java.task.javaStudy.threadTask;

public class ThreadLocalClientTest {

    public static String flag ;

    public static String getFlag() {
        return flag;
    }

    public static void setFlag(String flag) {
        ThreadLocalClientTest.flag = flag;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            ThreadLocalClientTest.setFlag(String.valueOf(finalI));
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": 的flag 是" + ThreadLocalClientTest.getFlag());
            }, "线程---" + i).start();
        }

        System.out.println("静态变量的值是:" + ThreadLocalClientTest.getFlag() + Thread.currentThread().getName());
    }
}
