package com.scott.java.task.clone;

import lombok.Data;

import java.util.List;

@Data
public class Dog implements Cloneable {

    private int weight;

    private String color;

    private List<String> list;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Dog)super.clone();
    }
}
