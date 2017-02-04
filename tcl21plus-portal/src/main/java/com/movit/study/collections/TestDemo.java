package com.movit.study.collections;

/**
 * Created by admin on 2017/2/2.
 */
public class TestDemo {
    public static void main(String[] args) {
        IntegerTest();
        System.out.println("----------------------------------");
        IntegerTest1();
    }

    public static void IntegerTest() {
        Integer i1 = 400;
        Integer i2 = 400;
        Integer i3 = 0;
        Integer i4 = new Integer(400);
        Integer i5 = new Integer(400);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2\t" + (i1 == i2));
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));

        Integer i7 = 400;
        System.out.println("i1=i7\t" + (i1 == i7));

    }

    public static void IntegerTest1() {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2\t" + (i1 == i2));
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));
    }
}
