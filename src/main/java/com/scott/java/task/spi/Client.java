package com.scott.java.task.spi;

import java.util.ServiceLoader;

/**
 * @author scott
 * @date 2019/6/15 16:21
 */
public class Client {

    public static void main(String[] args) {
        ServiceLoader<NinjaService> ninjaServices = ServiceLoader.load(NinjaService.class);
        for (NinjaService item : ninjaServices) {
            item.performTask();
        }
    }
}