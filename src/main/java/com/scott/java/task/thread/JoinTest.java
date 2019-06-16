package com.scott.java.task.thread;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName() + "启动");
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
        );

        Thread b = new Thread(
                ()->{
                    System.out.println(Thread.currentThread().getName() + "启动");
                    try {
                        System.out.println(Thread.currentThread().getName() + "sleep 3 秒");
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
        );
        b.start();
        b.join();
        a.start();
    }
}
