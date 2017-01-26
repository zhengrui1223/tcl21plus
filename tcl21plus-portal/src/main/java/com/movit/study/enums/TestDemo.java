package com.movit.study.enums;

import org.junit.Test;

import java.util.Random;

/**
 * Created by admin on 2017/1/15.
 */
public class TestDemo {

    @Test
    public void test(){
        String tuesday = WeekDay.getDay("Mon");
        System.out.println(tuesday);
    }

    @Test
    public void test1(){
        WeekDay[] values = WeekDay.values();
        for (WeekDay weekDay:values){
            System.out.println("name: " + weekDay.name() + " value: " + WeekDay.getDay(weekDay.name()));
            //System.out.println(weekDay.toString());
            System.out.println();
        }

    }
}
