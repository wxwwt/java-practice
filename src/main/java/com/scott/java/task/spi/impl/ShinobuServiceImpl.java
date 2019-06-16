package com.scott.java.task.spi.impl;

import com.scott.java.task.spi.NinjaService;

/**
 * @author scott
 * @date 2019/6/15 16:20
 */
public class ShinobuServiceImpl implements NinjaService {

    @Override
    public void performTask() {
        System.out.println("下忍在执行D级任务");
    }
}