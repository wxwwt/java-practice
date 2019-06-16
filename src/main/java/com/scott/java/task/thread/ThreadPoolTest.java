package com.scott.java.task.thread;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @author scott
 * @date 2019/3/14 22:51
 */
public class ThreadPoolTest {

    /**
     * coreSize是线程池的核心池数量,maxSize是最大线程池数量,blockQueue是阻塞队列的数量
     *
     * 一个线程池最多容纳的数量是maxSize + blockQueue
     *
     * 最多在运行的数量是maxSize
     *
     * 比如 core:3 ,max:5, block:4
     * 一共7个线程进来的话,3个在core,然后4个在block里面, core里面的处理完了,block里面的任务就进入到core,总共最多只会有三个线程在跑
     *
     * 例子2: core:3, max:10, block:5
     * 一共16个线程进来,max+block=15 多出来的一个会被默认的拒绝策略给拒绝掉,并且抛出异常.剩下的10个线程在跑,5个在block里面等待
     */

    private static final ExecutorService executorService = new ThreadPoolExecutor(3, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(5));

    public static void main(String[] args) {
        for (int i = 0; i < 16; i ++) {
            executorService.execute(()->{
                System.out.println("当前线程:" + Thread.currentThread().getName() + "当前时间:" + System.currentTimeMillis());
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}