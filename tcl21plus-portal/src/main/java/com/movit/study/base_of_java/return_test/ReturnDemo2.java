package com.movit.study.base_of_java.return_test;

/**
 * Created by admin on 2017/3/25.
 */
public class ReturnDemo2 {
    /**
     * 这说明finally里的return直接返回了，就不管try中是否还有返回语句
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(test2());
    }

    public static int test2() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            return 200;
        }

        // return b;
    }
}
