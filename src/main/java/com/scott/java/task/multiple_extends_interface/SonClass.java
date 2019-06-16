package com.scott.java.task.multiple_extends_interface;

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
