package person;

import com.movit.model.Person;
import com.movit.service.IPersonService;
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
public class PersonTest {

    @Autowired
    private IPersonService personService;

    @Test
    public void findAll(){
        List<Person> personList = personService.findAll();
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            System.out.println(person);
        }

    }

    @Test
    public void insert(){
        Person person = new Person();
        //person.setId(2);
        person.setName("lisi");
        person.setPassword("123456");

        boolean insert = personService.insert(person);
        System.out.println("#########" + insert);
    }

    @Test
    public void delete(){
        boolean b = personService.deleteById(4);
        System.out.println("#######" + b);
    }
}
