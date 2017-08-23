package com.movit.study.base_of_java.exception;

/**
 * Created by Administrator on 2017/2/10.
 */
public class ExcptionDemo2 {
    static void f() throws ExceptionB{
        throw new ExceptionB("exception b");
    }

    static void g() throws ExceptionC {
        try {
            f();
        } catch (ExceptionB e) {
            e.printStackTrace();
            throw new ExceptionC("exception a");
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (ExceptionC e) {
            e.printStackTrace();
        }
    }
}

class ExceptionA extends Exception {
    public ExceptionA(String str) {
        super();
    }
}

class ExceptionB extends ExceptionA {

    public ExceptionB(String str) {
        super(str);
    }
}

class ExceptionC extends ExceptionA {
    public ExceptionC(String str) {
        super(str);
    }
}