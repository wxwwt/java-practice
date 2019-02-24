package com.scott.java.task.multipleextendsinterface;

public class Son implements IFather, IMother {

    @Override
    public String speak() {
        return "i am a child";
    }

    public static void main(String[] args) {
        IMother son = new Son();
        System.out.println(son.speak());
        IFather son2 = new Son();
        System.out.println(son2.speak());
    }
}
