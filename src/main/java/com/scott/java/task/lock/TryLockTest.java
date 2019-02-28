package com.scott.java.task.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @author scott
 */
public class TryLockTest {

        private ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //注意这个地方
        private Lock lock = new ReentrantLock();
        public static void main(String[] args) throws Exception {
            final TryLockTest test = new TryLockTest();

            new Thread(){
                @Override
                public void run() {
                    test.insert(Thread.currentThread());
                };
            }.start();

            //sleep(1000);
            new Thread(){
                @Override
                public void run() {
                    test.insert(Thread.currentThread());
                };
            }.start();
        }

        public void insert(Thread thread) {
            if(lock.tryLock()) {
                try {
                    System.out.println(thread.getName()+"得到了锁");
                    for (int i = 0; i < 5; i++) {
                        arrayList.add(i);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }finally {
                    System.out.println(thread.getName()+"释放了锁");
                    lock.unlock();
                }
            } else {
                System.out.println(thread.getName()+"获取锁失败");
            }
        }

}
