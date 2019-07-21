package com.scott.java.task.multipleextendsinterface;

public class SonClass extends Father {

    @Override
    String speak() {
        return "SonClass";
    }
    public static void main(String[] args) {
        Father son = new SonClass();
        System.out.println(son.speak());
    }
}
