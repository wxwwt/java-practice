package com.scott.java.task.thread;

import java.util.Date;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class CallableTask {

    public static void main(String[] args) throws Exception {
            FutureTask<String> futureTask1 = new FutureTask<>(() -> {
                System.out.println("当前线程是:" + Thread.currentThread().getName());
                sleep(10000);
                return Thread.currentThread().getName() + "success" + new Date();
            });
            new Thread(futureTask1).start();

        FutureTask<String> futureTask2 = new FutureTask<>(() -> {
            System.out.println("当前线程是:" + Thread.currentThread().getName());
            sleep(2000);
            return Thread.currentThread().getName() + "success" + new Date();
        });
        new Thread(futureTask2).start();

        System.out.println(futureTask2.get());
        System.out.println(futureTask1.get());

    }



}
