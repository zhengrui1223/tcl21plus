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

        final UserService userService = (UserService) context.getBean("userService");
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

    private static void insert(UserService userService) {
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

}
