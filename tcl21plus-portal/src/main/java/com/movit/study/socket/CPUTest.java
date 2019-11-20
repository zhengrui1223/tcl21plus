package com.movit.study.socket;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2019-11-19 10:04
 ************************************************************/

public class CPUTest {

    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
    }

}
