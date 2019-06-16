package com.scott.java.task.clone_test;

public class ShadowClone {

    public static void main(String[] args) throws Exception {
        Dog dog1 = new Dog();
        dog1.setWeight(30);
        dog1.setColor("black");
        dog1.setHeight(30);
        System.out.println("克隆前dog1的值: " + dog1.toString());
        Dog dog2;
        dog2 = (Dog) dog1.clone();
        System.out.println("克隆犬的值: " + dog2.toString());
        System.out.println("犬1和犬2的内存地址是否相同: " + (dog1 == dog2));
        dog2.setWeight(15);
        dog2.setColor("red");
        dog2.setHeight(15);
        System.out.println("修改克隆犬的值: " + dog2.toString());
        System.out.println("克隆后dog1的值: " + dog1.toString());

    }
}
