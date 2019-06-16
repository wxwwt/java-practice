package com.scott.java.task.thread;

public class ThreadLocalTest {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setValue(String var) {
        threadLocal.set(var);
    }

    public static String getValue() {
        return threadLocal.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            ThreadLocalTest.setValue(String.valueOf(finalI));
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": 的flag 是" + ThreadLocalTest.getValue());
            }, "线程---" + i).start();
        }

        System.out.println("静态变量的值是:" + ThreadLocalTest.getValue() + Thread.currentThread().getName());
    }

//    public static void main(String[] args) {
//        System.out.println(threadLocal.get());
//    }
}
