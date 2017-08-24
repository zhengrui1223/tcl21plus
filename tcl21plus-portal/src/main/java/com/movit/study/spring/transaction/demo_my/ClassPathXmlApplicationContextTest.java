package com.movit.study.spring.transaction.demo_my;

import com.movit.study.model.Person;
import com.movit.study.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@SuppressWarnings("Duplicates")
public class ClassPathXmlApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/study/spring/transaction_my.xml");

        final UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        TransactionTemplate transactionTemplate = userService.getTransactionTemplate();

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            public void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    insert(userService);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    transactionStatus.setRollbackOnly();
                }

            }
        });

    }

    private static void delete(UserServiceImpl userService, int i) {
        boolean delete = userService.delete(i);
        System.out.println(delete);
    }

    private static void update(UserServiceImpl userService) {
        User user = new User();
        user.setId(2);
        user.setName("testName1_update");
        user.setPassWord("abc123");
        User update = userService.update(user);
        System.out.println(update);
    }

    private static void insert(UserServiceImpl userService) {
        User user = new User();
        user.setName("testName5");
        user.setPassWord("abc123");

        Person person = new Person();
        person.setAge(1);
        person.setName("testPerson5");

        user.setPerson(person);
        User insert = userService.insert(user);
        System.out.println(insert);
    }

    private static User getUserById(UserServiceImpl userService, int i) {
        User user = userService.getUserById(1);
        //System.out.println(user);
        return user;
    }
}
