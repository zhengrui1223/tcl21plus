package singleton;

import com.movit.utils.HttpClientUtil;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by admin on 2017/7/11.
 */
public class SingletonTest {
    private HttpClientUtil client = new HttpClientUtil();
    private static final String URL = "http://localhost:8080/singleton";

    @Test
    public void callSingletonServlet() throws InterruptedException {
        for (int i=0; i<10; i++) {
            SingletonThread thread = new SingletonThread();
            thread.join();
            thread.start();
        }
    }

    private class SingletonThread extends Thread {

        @Override
        public void run() {
            JSONObject jsonObject = client.query(URL, null, null);
            System.out.println(jsonObject.toString());
        }
    }

}
