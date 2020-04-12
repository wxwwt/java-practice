package com.scott.java.task.thread;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal1 = ThreadLocal.withInitial(() -> "withInitial的初始值");

    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "override initialValue的初始值";
        }
    };

    public static void main(String[] args) {
            Thread thread1 = new Thread();
            Thread thread2 = new Thread();
            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
    }

//    public static void main(String[] args) {
//        System.out.println(threadLocal.get());
//    }
}
