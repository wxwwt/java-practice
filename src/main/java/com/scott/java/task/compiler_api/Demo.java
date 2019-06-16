package com.scott.java.task.compiler_api;

import java.util.Date;

/**
 * @author scott
 * @date 2018/12/17 19:46
 */

public class Demo {

    public void doSomething(){
             Date date = new Date(10, 3, 3);
        // 这个构造函数被标记为deprecated, 编译时会
        // 向错误输出输出信息。
             System.out.println("Doing...");
           }
}
