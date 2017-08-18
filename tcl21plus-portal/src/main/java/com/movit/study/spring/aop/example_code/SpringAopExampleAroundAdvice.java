package com.movit.study.spring.aop.example_code;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.study.model.User;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SpringAopExampleAroundAdvice implements MethodInterceptor {
    private static int userId;

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        //打印当前时间
        System.out.println("print server time " + System.currentTimeMillis());

        //判断登录用户是否为admin
        Object[] arguments = methodInvocation.getArguments();
        if ("admin".equals(arguments[0])) {
            System.out.println("you can't find admin's info");
            return null;
        }

        //打印用户信息
        User user = (User)methodInvocation.proceed();
        //为User的Id属性赋值

        //change user's info , set id
        synchronized (this) {
            user.setId(userId++);
        }

        System.out.println("当前用户信息为: " + new ObjectMapper().writeValueAsString(user));

        return user;
    }

}
