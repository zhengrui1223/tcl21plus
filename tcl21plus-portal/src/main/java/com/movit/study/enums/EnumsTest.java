package com.movit.study.enums;

/**
 * Created by admin on 2017/1/27.
 */
public class EnumsTest {
    public static void main(String[] args) {
        /*String day = WeekDay.getDay("Mon");
        System.out.println(day);*/

        WeekDay[] values = WeekDay.values();
        for (WeekDay weekDay:values){
            System.out.println("name: " + weekDay.name() + " value: " + WeekDay.getDay(weekDay.name()));
            //System.out.println(weekDay.toString());
            System.out.println();
        }
    }
}
