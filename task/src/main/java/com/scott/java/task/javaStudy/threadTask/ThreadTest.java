package com.scott.java.task.javaStudy.threadTask;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread thread = new Thread(()-> System.out.println("thread is alive"));
        try {
            thread.join(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
