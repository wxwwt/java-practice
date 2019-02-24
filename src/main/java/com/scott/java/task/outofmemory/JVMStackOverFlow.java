package com.scott.java.task.outofmemory;

/**
 * @author scott
 * @date 2018/12/28 16:40
 * jvmArgs :-Xss128K
 */

public class JVMStackOverFlow {


    private int stackLength = 0;

    public void stackOverflow() {
        ++stackLength;
        stackOverflow();
    }

    public static void main(String[] args) throws Throwable {
        JVMStackOverFlow test = new JVMStackOverFlow();

        try {
            test.stackOverflow();
        } catch (Throwable e) {
            System.out.println("stack length: " + test.stackLength);
            System.out.println("进入断点,此时已经栈溢出");
            throw e;
        }
    }

}
