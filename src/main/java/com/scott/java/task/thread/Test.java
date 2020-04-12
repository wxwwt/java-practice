package com.scott.java.task.thread;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.*;

public class Test {

    public static final String FLAG = "@#";
    private final List<Person> list = new ArrayList<>();

    public void add(Person person) {
        list.add(person);
    }

    public static void main(String[] args) {
        System.out.println(generatorAnalysis());
    }

    private static String generatorAnalysis() {
        final String FLAG = "@#";
        // @#/rank/indexPlus/brand_id/1@#52217050198@#1
        // 时间戳的差值
        Long time = System.currentTimeMillis() - 1515125653845L;
        // 请求的api
        String baseUrl = "/rank/indexPlus/brand_id/1";
        StringBuilder builder = new StringBuilder(FLAG);
        // 拼接字符串的规则 api + @# + 时间戳差值 + @#1
        builder.append(baseUrl).append(FLAG).append(time).append(FLAG).append(1);
        // 自定义的加密 这里加密函数不就给出了  可以自己根据断点里面的值推算出来哦
        String encodeStr = diyEncode(builder.toString());
        // 最后base编码下
        return new String(Base64.getEncoder().encode(encodeStr.getBytes()));
    }

    public static String diyEncode(String a) {
        return "aa";
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name;

    private Integer age;
}