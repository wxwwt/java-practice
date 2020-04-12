package com.scott.java.task.clone;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CloneTest {

    public static void main(String[] args) throws Exception {
         //shallowCopy();
        deepCopy();
    }

    public static void shallowCopy() {
        Dictionary dictionary1 = new Dictionary();
        dictionary1.setName("汉语词典");
        dictionary1.setWords(new ArrayList<String>() {{
            add("你好");
            add("浅拷贝");
        }});
        Dictionary dictionary2 = (Dictionary) dictionary1.clone();
        System.out.println(dictionary1 == dictionary2);
        dictionary2.getWords().add("新词语");
        System.out.println("dictionary1: " + dictionary1.toString());
        System.out.println("dictionary2: " + dictionary2.toString());

        dictionary1.setName("新名字");
        System.out.println("dictionary1: " + dictionary1.toString());
        System.out.println("dictionary2: " + dictionary2.toString());
    }

    private static void deepCopy() throws IOException, ClassNotFoundException {
        Dictionary dictionary1 = new Dictionary();
        dictionary1.setName("汉语词典");
        dictionary1.setWords(new ArrayList<String>() {{
            add("你好");
            add("深拷贝");
        }});

        Dictionary dictionary2 = null;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(dictionary1);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        dictionary2 = (Dictionary) ois.readObject();

        // 测试方法没关闭流 实际项目记得关闭流
        System.out.println(dictionary1 == dictionary2);
        dictionary2.getWords().add("新词语");
        System.out.println("dictionary1: " + dictionary1.toString());
        System.out.println("dictionary2: " + dictionary2.toString());
    }
}

@Data
class Dictionary implements Cloneable, Serializable {

    private String name;

    private List<String> words;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}