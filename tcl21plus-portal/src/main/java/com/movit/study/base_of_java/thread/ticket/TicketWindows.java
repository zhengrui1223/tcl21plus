package com.movit.study.base_of_java.thread.ticket;

/**
 * Created by Administrator on 2017/2/16.
 */
public class TicketWindows implements Runnable {
    private int tickets = 2000;// 总票数

    public void run() {
        while (true) {
            //要保证其原子性 同步代码块
            synchronized (this) {
                // 判断是否还有票
                if (tickets > 0) {
                    // 显示售票信息
                    System.out.println(Thread.currentThread().getName()
                            + "正在售票中   ....还剩" + tickets + "张票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tickets--;
                } else {
                    // 退出售票窗口
                    break;
                }
            }
        }
    }
}


class TestTickets {
    public static void main(String[] args) {
        ///创建了3个窗口 每一个窗口代表一个线程
        /*TicketWindows tWindows1 = new TicketWindows();
        TicketWindows tWindows2 = new TicketWindows();
        TicketWindows tWindows3 = new TicketWindows();
        Thread thread1 = new Thread(tWindows1);
        Thread thread2 = new Thread(tWindows2);
        Thread thread3 = new Thread(tWindows3);
        thread1.start();
        thread2.start();
        thread3.start();*/

        //创建一个窗口
        TicketWindows tWindows1 = new TicketWindows();
        Thread thread1 = new Thread(tWindows1);
        Thread thread2 = new Thread(tWindows1);
        Thread thread3 = new Thread(tWindows1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
