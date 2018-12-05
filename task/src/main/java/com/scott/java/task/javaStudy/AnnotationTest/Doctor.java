package com.scott.java.task.javaStudy.AnnotationTest;

import org.scott.myannotationprocessor.annotation.Test;

@Test
public class Doctor {

    //诊断
    private void diagnose(){
        System.out.println("diagnose...");
    }

    //行走
    public void walk(){
        System.out.println("walking");
    }
}