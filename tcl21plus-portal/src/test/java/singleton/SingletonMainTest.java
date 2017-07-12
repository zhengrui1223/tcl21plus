package singleton;

import com.movit.study.singleton.Singleton1;
import com.movit.study.singleton.Singleton2;
import com.movit.study.singleton.Singleton3;
import com.movit.study.singleton.Singleton4;
import com.movit.utils.HttpClientUtil;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.*;

/**
 * Created by admin on 2017/7/11.
 * 本来想用junit测试多线程并发的,百度一下发现junit不支持多线程测试,晕死..
 * 故需要在java main方法中测试多线程
 */
public class SingletonMainTest {
    private static HttpClientUtil client = new HttpClientUtil();
    private static final String SINGLETON1_URL = "http://localhost:8080/singleton/singleton1";
    private static final String SINGLETON2_URL = "http://localhost:8080/singleton/singleton2";
    private static final String SINGLETON3_URL = "http://localhost:8080/singleton/singleton3";
    private static final String SINGLETON4_URL = "http://localhost:8080/singleton/singleton4";

    public static void main(String[] args) throws InterruptedException {

        SingletonThread1 singletonThread = new SingletonThread1();
//        SingletonThread2 singletonThread = new SingletonThread2();

        for (int i=0; i<10; i++) {
            Thread thread = new Thread(singletonThread);
            thread.join();
            thread.start();
        }

    }

    /**
     * 通过web请求获取单列中的实例变量的值来测试单列
     */
    private static class SingletonThread1 extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //饿汉式 get请求测试
            /*JSONObject query = client.query(SINGLETON1_URL, null, null);
            System.out.println(query.toString());*/

            //懒汉式 get请求测试 非线程安全
            JSONObject query = client.query(SINGLETON2_URL, null, null);
            System.out.println(query.toString());

            //懒汉式 get请求测试 线程安全低效
            /*JSONObject query = client.query(SINGLETON3_URL, null, null);
            System.out.println(query.toString());*/

            //懒汉式 get请求测试 线程安全高效
            /*JSONObject query = client.query(SINGLETON4_URL, null, null);
            System.out.println(query.toString());*/
        }
    }

    /**
     * 直接获取实例hashcode测试单列
     */
    private static class SingletonThread2 extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //饿汉式测试
//            System.out.println(Singleton1.getInstance().hashCode());

            //懒汉式测试 非线程安全
            System.out.println(Singleton2.getInstance().hashCode());

            //懒汉式测试 线程安全  低效
            //System.out.println(Singleton3.getInstance().hashCode());

            //懒汉式测试 线程安全  高效
            /*System.out.println(Singleton4.getInstance().hashCode());*/
        }
    }

}
