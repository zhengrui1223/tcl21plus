package com.movit.study.spi.jdk;

import java.util.ServiceLoader;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-12-12 21:09
 ************************************************************/

public class JavaSPITest {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

}
