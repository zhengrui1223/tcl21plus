package com.movit.study.integer;

/**
 * Created by Administrator on 2017/3/2.
 */
public class TestIntegerDemo {
    public static void main(String [] args){

        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println("i1 == i2 " + (i1 == i2));

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println("i3 == i4 " + (i3 == i4));

        Integer i5 = new Integer(1);
        Integer i6 = new Integer(1);
        System.out.println("i5 == i6 " + (i5 == i6));

        Integer i7 = 1;
        int i8 = 1;
        System.out.println("i7 == i8 " + (i7 == i8));

        Integer var1 = new Integer(1);
        Integer var2 = var1;
        System.out.println("var1 == var2" + (var1 == var2));
        changeInteger(var2);
        System.out.println(var1);

    }

    private static void changeInteger(Integer integer) {
        integer = new Integer(2);
    }
}
