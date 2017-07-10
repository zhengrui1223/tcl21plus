package com.movit.study.string;

public class RuntimeConstantPoolOOM {

    public static void main(String[]args){
        //test1();
        //test2();
        //test3();
        test4();
    }

    public static void test1(){
        String str1 = new StringBuilder("计算机").append("软件").toString(); //true
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString(); //false
        System.out.println(str2.intern() == str2);
    }

    public static void test2(){
        String str1 = new String("计算机");
        System.out.println(str1.intern() == str1); //false
        String str2 = new String("ja");
        System.out.println(str2.intern() == str2); //false
    }

    public static void test3(){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        String str2 = new String("计算机软件");
        System.out.println(str1 == str2);
    }

    public static void test4(){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        String str2 = "计算机软件";
        System.out.println(str1 == str2);
    }
}
