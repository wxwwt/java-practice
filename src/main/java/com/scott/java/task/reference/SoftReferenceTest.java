package com.scott.java.task.reference;

import java.lang.ref.*;
import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author scott
 * @date 2019/5/26 11:13
 */
public class SoftReferenceTest {

    public static boolean isRun = true;

    public static void main(String[] args) throws Exception {
        Object abc = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> abcRef = new PhantomReference<Object>(abc, refQueue);
        System.out.println("队列中的东西：" + refQueue.poll());
        abc = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("引用加入队列了吗？ " + abcRef.isEnqueued());
        System.out.println("队列中的东西：" + refQueue.poll());
        /**
         * 输出：
         * 队列中的东西：null
         * 引用加入队列了吗？ true
         * 队列中的东西：java.lang.ref.PhantomReference@7bb11784
         */
    }


//    public static void main(String[] args) throws InterruptedException {
//        Object obj = new Object();
//        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
//        WeakReference<Object> weakRef = new WeakReference<>(obj, refQueue);
//        System.out.println("引用：" + weakRef.get());
//        System.out.println("队列中的东西：" + refQueue.poll());
//        // 清除强引用, 触发GC
//        obj = null;
//        System.gc();
//        Thread.sleep(200);
//        System.out.println("引用：" + weakRef.get());
//        System.out.println("引用加入队列了吗？ " + weakRef.isEnqueued());
//        System.out.println("队列中的东西：" + refQueue.poll());
//        /**
//         * 输出结果
//         * 引用：java.lang.Object@7bb11784
//         * 队列中的东西：null
//         * 引用：null
//         * 引用加入队列了吗？ true
//         * 队列中的东西：java.lang.ref.WeakReference@33a10788
//         */
//        WeakHashMap
//    }


}