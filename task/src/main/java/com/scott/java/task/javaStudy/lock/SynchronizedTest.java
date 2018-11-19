package com.scott.java.task.javaStudy.lock;

public class SynchronizedTest extends Thread {

    @Override
    public void run() {
        get();
    }

    public synchronized void  get() {
        System.out.println(Thread.currentThread().getName() + "执行get方法");
        set();
    }


    public synchronized  void set() {
        System.out.println(Thread.currentThread().getName() + "执行set方法");
    }

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        test.start();
    }
}
