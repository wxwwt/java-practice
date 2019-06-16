package com.scott.java.task;

import com.scott.java.task.threadTask.Test;

/**
 * @author scott
 * @date 2019/4/9 22:45
 */
public class NoVisibilityTest {

    private  static boolean ready;

    private static int number;

    private static class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "____" + Thread.currentThread().getPriority());
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.setPriority(10);
        testThread.start();
        System.out.println(Thread.currentThread().getName() + "____" + Thread.currentThread().getPriority());
        number = 222;
        ready = true;
    }
}