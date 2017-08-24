package com.movit.study.spring.transaction.demo_annotation;

import com.movit.study.model.Person;
import com.movit.study.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("Duplicates")
public class ClassPathXmlApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/study/spring/transaction_annotation1.xml");

        IUserService userService = (IUserService) context.getBean("userService");

        getUserById(userService, 1);
        //insert(userService);
        //update(userService);
        //delete(userService, 3);

    }

    private static void delete(IUserService userService, int i) {
        boolean delete = userService.delete(i);
        System.out.println(delete);
    }

    private static void update(IUserService userService) {
        User user = new User();
        user.setId(2);
        user.setName("testName1_update");
        user.setPassWord("abc123");
        User update = userService.update(user);
        System.out.println(update);
    }

    private static void insert(IUserService userService) {
        User user = new User();
        user.setName("testName2");
        user.setPassWord("abc123");

        Person person = new Person();
        person.setAge(1);
        person.setName("testPerson2");

        user.setPerson(person);
        User insert = userService.insert(user);
        System.out.println(insert);
    }

    private static void getUserById(IUserService userService, int i) {
        User user = userService.getUserById(1);
        System.out.println(user);
    }
}
