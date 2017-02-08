package user_test;

import com.movit.model.User;
import com.movit.utils.HttpClient4Util;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Administrator on 2017/2/8.
 */
public class UserTest {

    @Test
    public void getUserById() throws UnsupportedEncodingException, URISyntaxException {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/testUser/1")
                //.setParameter("id", "1")
                .build();

        HttpGet httpGet = new HttpGet(uri);
        Header header = new BasicHeader("Basic", "CN");
        httpGet.setHeader(header);

        String response = HttpClient4Util.callByGet(httpGet);
        System.out.println(response);

    }

    @Test
    public void getAllUser() throws UnsupportedEncodingException, URISyntaxException {
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/testUser")
                .build();

        HttpGet httpGet = new HttpGet(uri);
//        Header header = new BasicHeader("Basic", "CN");
//        httpGet.setHeader(header);

        String response = HttpClient4Util.callByGet(httpGet);
        System.out.println(response);

    }

    @Test
    public void insertUser() throws URISyntaxException {
        User user = new User();
        user.setId(5);
        user.setName("fdsfd");
        user.setPassword("123456");

        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("localhost:8080")
                .setPath("/testUser")
                .build();

        HttpPost httpPost = new HttpPost(uri);
        String response = HttpClient4Util.callByPost(user, httpPost);
        System.out.println(response);
    }
}
