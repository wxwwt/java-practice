package com.scott.java.task.javaStudy.threadTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTask implements Callable<String> {

    public static void main(String[] args) {
        CallableTask callableTask = new CallableTask();
        FutureTask<String> future = new FutureTask<>(callableTask);
        for (int i = 0; i < 20; i++) {
            new Thread(future).start();
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
       // AtomicInteger
    }


    @Override
    public String call() throws Exception {
        return "返回值的线程:" + Thread.currentThread().getName();
    }
}
