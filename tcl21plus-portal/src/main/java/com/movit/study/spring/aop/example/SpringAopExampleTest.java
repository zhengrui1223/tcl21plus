package com.movit.study.spring.aop.example;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class SpringAopExampleTest {

    public static void main(String[] args) {
        //切入点定义
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        //拦截哪些方法
        pointcut.setMappedNames(new String[] {"get*", ""});

        //Around Advice
        SpringAopExampleAroundAdvice aroundAdvice = new SpringAopExampleAroundAdvice();
        //Before Advice
        SpringAopExampleBeforeAdvice beforeAdvice = new SpringAopExampleBeforeAdvice();
        //Throws Advice
        SpringAopExampleThrowsAdvice throwsAdvice = new SpringAopExampleThrowsAdvice();
        //After Returning Advice
        SpringAopExampleAfterReturningAdvice afterReturningAdvice = new SpringAopExampleAfterReturningAdvice();

        //切面定义
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(aroundAdvice);
        //advisor.setAdvice(beforeAdvice);
        //advisor.setAdvice(throwsAdvice);
        //advisor.setAdvice(afterReturningAdvice);

        //织入
        ProxyFactory proxyFactory = new ProxyFactory(new UserService());
        proxyFactory.addAdvisor(advisor);

        //使用目标代理对象
        UserService userService = (UserService)proxyFactory.getProxy();
        userService.getUserInfo("jerry1", "123456");
        userService.getUserInfo("jerry2", "123456");
        userService.getUserInfo("jerry3", "123456");
        userService.getUserInfo("jerry4", "123456");
        userService.getUserInfo("jerry5", "123456");
        userService.getUserInfo("admin", "123456");

        //userService.getUserInfoException();

    }

}
