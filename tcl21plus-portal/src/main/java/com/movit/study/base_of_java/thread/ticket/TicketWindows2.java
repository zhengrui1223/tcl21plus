package com.movit.study.base_of_java.thread.ticket;

/**
 * Created by Administrator on 2017/2/16.
 */
public class TicketWindows2 extends Thread {
    private int tickets = 2000;
    @Override
    public synchronized void run() {
        while (true){
            if (tickets >0){
                System.out.println(Thread.currentThread().getName()
                        + "正在售票中   ....还剩" + tickets + "张票");
                tickets--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                break;
            }
        }
    }
}

class Test{
    public static void main(String[] args){
        TicketWindows2 threadWindows = new TicketWindows2();
        Thread thread1 = new Thread(threadWindows);
        Thread thread2 = new Thread(threadWindows);
        Thread thread3 = new Thread(threadWindows);
        thread1.start();
        thread2.start();
        thread3.start();

        /*TicketWindows2 threadWindows1 = new TicketWindows2();
        TicketWindows2 threadWindows2 = new TicketWindows2();
        TicketWindows2 threadWindows3 = new TicketWindows2();
        threadWindows1.start();
        threadWindows2.start();
        threadWindows3.start();*/
    }
}
