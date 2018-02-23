package com.movit.study.base_of_java.integer;

/**
 * JVM维护Integer范围为-128到127 的对象的缓存，故当创建Integer对象的值是在此范围中时，该对象并不会创建，而是将缓冲池中的对象的引用返回。
 */
public class TestIntegerDemo {
    public static void main(String [] args){

        Integer i1 = 1; //相当于Integer.valueOf("1")，此时取到的对象是来源于缓冲池中
        Integer i2 = 1;
        System.out.println("i1 == i2 " + (i1 == i2));

        Integer i3 = 128;   //128并不在缓冲池中
        Integer i4 = 128;
        System.out.println("i3 == i4 " + (i3 == i4));

        Integer i5 = new Integer(1);    //因为创建了两个对象，==比较的是hashCode， 故i5 i6肯定不同的。
        Integer i6 = new Integer(1);
        System.out.println("i5 == i6 " + (i5 == i6));

        Integer i7 = 1; //自动装箱，相当于Integer.valueOf("1")
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
