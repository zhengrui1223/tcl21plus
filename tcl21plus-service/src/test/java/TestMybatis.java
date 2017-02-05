import com.movit.model.User;
import com.movit.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by admin on 2017/2/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis-test.xml"})
public class TestMybatis {
    @Autowired
    private IUserService userService;

    @Test
    public void testConnection(){
        User user = userService.getUserById(1);
        System.out.println(user);
    }
}
