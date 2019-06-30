package com.scott.java.task.inputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author shenchuang
 * @since 2019-06-30
 */
public class InputStreamTest {

    public static void main(String[] args) throws IOException {
        // 不能重复读的方法
        System.out.println("开始执行method1......");
        method1();
        // 使用byteArrayOutputStream重复读inputStream
        System.out.println("开始执行method2......");
        method2();
        // 使用mark重复读inputStream
        System.out.println("开始执行method3......");
        method3();
    }

    public static void method1() throws IOException {
        String text = "测试inputStream内容";
        InputStream inputStream = new ByteArrayInputStream(text.getBytes());
        byte[] readArray = new byte[inputStream.available()];
        int readCount1 = inputStream.read(readArray);
        System.out.println("读取了" + readCount1 + "个字节");

        byte[] readArray2 = new byte[inputStream.available()];
        int readCount2 = inputStream.read(readArray2);
        System.out.println("读取了" + readCount2 + "个字节");
    }

    /**
     * 使用byteArrayOutputStream做缓存
     */
    public static void method2() throws IOException {
        String text = "测试inputStream内容";
        InputStream rawInputStream = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = rawInputStream.read(buffer)) > -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.flush();
        InputStream in1 = new ByteArrayInputStream(outputStream.toByteArray());
        InputStream in2 = new ByteArrayInputStream(outputStream.toByteArray());
        int readCount1 = in1.read(buffer);
        int readCount2 = in2.read(buffer);
        System.out.println("读取了" + readCount1 + "个字节");
        System.out.println("读取了" + readCount2 + "个字节");
    }

    /**
     * 使用mark和reset方法
     */
    public static void method3() throws IOException {
        String text = "测试inputStream内容";
        InputStream rawInputStream = new ByteArrayInputStream(text.getBytes());
        byte[] readArray = new byte[1024];
        rawInputStream.mark(6);
        int readCount1 = rawInputStream.read(readArray);
        rawInputStream.reset();
        int readCount2 = rawInputStream.read(readArray);
        System.out.println("读取了" + readCount1 + "个字节");
        System.out.println("读取了" + readCount2 + "个字节");
    }
}
