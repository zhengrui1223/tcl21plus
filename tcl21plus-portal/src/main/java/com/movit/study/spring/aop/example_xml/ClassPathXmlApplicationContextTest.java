package com.movit.study.spring.aop.example_xml;

import com.movit.study.spring.aop.example_code.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {

    public static void main(String []args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/study/spring/spring_aop.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.getUserInfo("jerry", "234");
        userService.getUserInfoException();
    }
}
