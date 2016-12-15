import org.junit.Test;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by admin on 2016/11/27.
 */
public class TestConnection {

    @Test
    public void test(){
        WebApplicationContext context = new XmlWebApplicationContext();
        context.getBean("");
    }
}
