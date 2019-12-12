package com.movit.study.jvm;

import java.util.concurrent.TimeUnit;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-12 11:48
 ************************************************************/

public class HookTest {

    public void start()
    {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("Execute Hook.....");
            }
        }));
    }

    public static void main(String[] args)
    {
        new HookTest().start();
        System.out.println("The Application is doing something");

        try
        {
            TimeUnit.MILLISECONDS.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
