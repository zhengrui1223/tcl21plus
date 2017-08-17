package com.movit.study.spring.ioc.classpathxmlapplicationcontext;

import com.movit.study.model.User;
import com.movit.study.spring.ioc.factory_bean.GetUserBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {

    public static void main(String []args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/study/spring/factory_bean.xml");

        GetUserBean getUserBean = (GetUserBean) context.getBean("getUserBean");
        User user = getUserBean.getUser();
        System.out.println(user);

    }
}
