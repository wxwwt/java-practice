package com.scott.java.task.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCountTest implements  Runnable {

    public static Lock lock  = new ReentrantLock();
    public static int j = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "进入run方法");
        for (int i = 0; i < 10000000; i++) {
            lock.lock();lock.lock();
            try {
                j++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int a = 6, b;
        b = a;
        a = 7;
        System.out.println(b);

    }
}
