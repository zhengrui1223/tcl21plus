package com.movit.study.base_of_java.thread.simple;

public class MutableInteger {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    private static class MutableIntegerFactory {
        private static MutableInteger mutableInteger;
        public static MutableInteger getMutableInteger() {
            if (mutableInteger == null) {
                return  new MutableInteger();
            }
            return mutableInteger;
        }
    }

    private class MyThread extends Thread{
        private int index;
        private MutableInteger integer;

        public MyThread(int index){
            this.index = index;
        }

        public MyThread(int index, MutableInteger integer){
            this.index = index;
            this.integer = integer;
        }

        @Override
        public void run() {
            integer.setValue(index);
            System.out.println("index = " + index + " MutableInteger = " + integer.getValue());

           /* MutableInteger mutableInteger = MutableIntegerFactory.getMutableInteger();
            mutableInteger.setValue(this.index);
            System.out.println("index = " + this.index + " mutableInteger = " + mutableInteger);*/

        }
    }

    public static void main(String []args){
        MutableInteger mutableInteger = new MutableInteger();
        for (int i=0; i<50; i++) {
            MyThread thread = new MutableInteger().new MyThread(i,mutableInteger);
            thread.start();
        }

        /*for (int i=0; i<50; i++) {
            MyThread thread = new MutableInteger().new MyThread(i);
            thread.start();
        }*/


    }
}
