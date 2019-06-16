package com.scott.java.task.spi.impl;

import com.scott.java.task.spi.NinjaService;

/**
 * @author scott
 * @date 2019/6/15 16:18
 */
public class ForbearanceServiceImpl implements NinjaService {

    @Override
    public void performTask() {
        System.out.println("上忍在执行A级任务");
    }
}