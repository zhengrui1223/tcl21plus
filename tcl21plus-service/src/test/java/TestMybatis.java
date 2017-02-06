import com.movit.model.Person;
import com.movit.model.User;
import com.movit.service.IUserService;
import com.movit.service.impl.TransactionTest;
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
    @Autowired
    private TransactionTest transactionTest;

    @Test
    public void testConnection(){
        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    public void testTransaction(){
        User user = new User();
        user.setName("lisi_user");
        user.setPassword("123456");

        Person person = new Person();
        person.setName("lisi_person");
        person.setPassword("123456");

        boolean isSuccess = transactionTest.insert(user, person);
        System.out.println("########" + isSuccess);
    }
}
