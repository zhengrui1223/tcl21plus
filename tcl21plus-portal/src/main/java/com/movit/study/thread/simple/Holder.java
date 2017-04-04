package com.movit.study.thread.simple;

/**
 * Created by admin on 2017/4/4.
 */
public class Holder {
    private int n;

    public void assertSanity(){
        /*Random random = new Random();
        int anInt = random.nextInt(100);
        n = anInt;
        if (n != anInt) {
            throw new AssertionError("This statement is false");
        }*/

        System.out.println(Thread.currentThread().getName() + " : " + n++);
    }

    private static class MyThread extends Thread {
        private Holder holder;

        public MyThread(Holder holder){
            this.holder = holder;
        }

        @Override
        public void run() {
            holder.assertSanity();
        }
    }

    public static void main(String []args){
        Holder holder = new Holder();
        MyThread myThread = new MyThread(holder);
        for (int i=0; i<100; i++) {
            Thread thread = new Thread(myThread);
            thread.start();
        }
    }
}
