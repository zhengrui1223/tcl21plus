import org.junit.Test;

import java.io.*;

/**
 * Created by admin on 2016/11/27.
 */
public class TestConnection {

    @Test
    public void test() throws IOException {
        BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(new File("F:/apps/apache-tomcat-7.0.70/webapps/portal/count.txt")));
        outputStream.write("hello".getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
