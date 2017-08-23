package com.movit.study.base_of_java.exception;

/**
 * Created by admin on 2017/2/7.
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            f();
        } catch (MyDemoException e) {
//            e.printStackTrace();
//            e.printStackTrace(System.out);
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace){
                System.out.println(stackTraceElement);
            }
        }

    }

    private static void f() throws MyDemoException {
        throw new MyDemoException("############");
    }
}

