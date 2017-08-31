package user;

import com.movit.model.User;
import com.movit.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2017/2/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis-test.xml"})
public class UserTest {
    @Autowired
    private IUserService userService;

    @Test
    public void findAll(){
        List<User> personList = userService.findAll();
        Iterator<User> iterator = personList.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            System.out.println(user);
        }
    }

    @Test
    public void insert(){
        User user = new User();
        user.setName("lisi");
        user.setPassword("123456");

        User insert = userService.insert(user);
        System.out.println("#########" + insert);
    }

    @Test
    public void delete(){
        boolean b = userService.deleteById(3);
        System.out.println("#######" + b);
    }
}
