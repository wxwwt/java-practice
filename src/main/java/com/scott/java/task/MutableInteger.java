package com.scott.java.task;

/**
 * @author scott
 * @date 2019/4/10 22:00
 */
public class MutableInteger {

    private int value = 11;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        MutableInteger mutableInteger = new MutableInteger();
        new Thread(
                ()-> {
                    System.out.println("当前线程是：" + Thread.currentThread().getName() + "_$1");
                    System.out.println("当前线城市: " + Thread.currentThread().getName() + "_$1, 值: " + mutableInteger.getValue());
                    mutableInteger.setValue(2);
                }
        ).start();

        new Thread(
                ()-> {
                    System.out.println("当前线城市: " + Thread.currentThread().getName() + "_$2, 值: " + mutableInteger.getValue());
                }).start();
        System.out.println("当前线城市: " + Thread.currentThread().getName() + "_main, 值: " + mutableInteger.getValue());
    }
}