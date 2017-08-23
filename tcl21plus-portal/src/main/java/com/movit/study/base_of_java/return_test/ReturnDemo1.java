package com.movit.study.base_of_java.return_test;

/**
 * Created by admin on 2017/3/25.
 */
public class ReturnDemo1 {
    /**
     * 说明return语句已经执行了再去执行finally语句，
     * 不过并没有直接返回，而是等finally语句执行完了再返回结果。
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(test11());
    }

    public static String test11() {
        try {
            System.out.println("try block");

            return test12();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test12() {
        System.out.println("return statement");

        return "after return";
    }
}
