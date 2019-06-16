package com.scott.java.task.clone_test;

import lombok.Data;

@Data
public class Dog implements Cloneable {

    private int weight;

    private String color;

    private Integer height;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Dog)super.clone();
    }
}
