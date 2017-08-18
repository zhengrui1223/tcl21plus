package com.movit.study.spring.aop.example_code;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class SpringAopExampleTest {

    public static void main(String[] args) {
        //切入点定义
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        //拦截哪些方法
        pointcut.setMappedNames(new String[]{"get*", ""});

        //Around Advice
        SpringAopExampleAroundAdvice aroundAdvice = new SpringAopExampleAroundAdvice();
        //Before Advice
        SpringAopExampleBeforeAdvice beforeAdvice = new SpringAopExampleBeforeAdvice();
        //Throws Advice
        SpringAopExampleThrowsAdvice throwsAdvice = new SpringAopExampleThrowsAdvice();
        //After Returning Advice
        SpringAopExampleAfterReturningAdvice afterReturningAdvice = new SpringAopExampleAfterReturningAdvice();

        //切面定义
        DefaultPointcutAdvisor[] advisors = new DefaultPointcutAdvisor[]{new DefaultPointcutAdvisor(pointcut, aroundAdvice),
                new DefaultPointcutAdvisor(pointcut, beforeAdvice),
                new DefaultPointcutAdvisor(pointcut, throwsAdvice),
                new DefaultPointcutAdvisor(pointcut, afterReturningAdvice)};

        //织入
        ProxyFactory proxyFactory = new ProxyFactory(new UserService());
        proxyFactory.addAdvisors(advisors);

        //使用目标代理对象
        UserService userService = (UserService) proxyFactory.getProxy();
        userService.getUserInfo("jerry1", "123456");
        userService.getUserInfo("admin", "123456");
        //userService.getUserInfoException();

    }

}
