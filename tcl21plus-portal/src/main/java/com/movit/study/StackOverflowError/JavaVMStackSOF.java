package com.movit.study.StackOverflowError;

/**
 * Created by MOVITECH-5-e450 on 2017/6/22.
 */
public class JavaVMStackSOF {

    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[]args)throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length：" + oom.stackLength);
            throw e;
        }
    }
}