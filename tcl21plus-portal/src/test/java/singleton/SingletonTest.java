package singleton;

import com.movit.utils.HttpClientUtil;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by admin on 2017/7/11.
 * 本来想用junit测试多线程并发的,百度一下发现junit不支持多线程测试,晕死..
 * 故需要在java main方法中测试多线程
 */
public class SingletonTest {
    private HttpClientUtil client = new HttpClientUtil();
    private static final String SINGLETON1_URL = "http://localhost:8080/singleton/singleton1";
    private static final String SINGLETON2_URL = "http://localhost:8080/singleton/singleton2";
    private static final String SINGLETON3_URL = "http://localhost:8080/singleton/singleton3";
    private static final String SINGLETON4_URL = "http://localhost:8080/singleton/singleton4";

    @Test
    public void callSingletonServlet() throws InterruptedException {
        SingletonThread singletonThread = new SingletonThread();
        //singletonThread.join();
        singletonThread.start();
        /*for (int i=0; i<10; i++) {
            Thread thread = new Thread(singletonThread);
            //thread.join();
            thread.start();
        }*/
    }

    @Test
    public void callSingletonServlet2() throws InterruptedException {
        JSONObject jsonObject = client.query(SINGLETON1_URL, null, null);
        System.out.println(jsonObject.toString());
    }

    private class SingletonThread extends Thread {

        @Override
        public void run() {
            client.query(SINGLETON1_URL, null, null);
        }
    }

}
