package com.scott.java.task.lock;

class LockTest {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

public class Count{
    LockTest lock = new LockTest();

    public void print() throws InterruptedException {
        lock.lock();
        System.out.println("执行了 print");
        doAdd();
        lock.unlock();
    }

    public void doAdd() throws InterruptedException {
        lock.lock();
        System.out.println("执行了adAdd");
        //do something
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        count.print();

    }
}