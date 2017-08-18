package com.movit.study.spring.aop.example_annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.study.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
@Aspect
@Component
public class SpringAopByAnnotation {
    private static int userId;

    @Pointcut(value = "execution(* com.movit.study.spring.aop.example_code.UserService.*(..))")
    public void commonPointCut() {
    }


    @Before("commonPointCut()")
    public void beforeAdvice(JoinPoint joinPoint) throws JsonProcessingException {
        System.out.println("[--------------beforeAdvice--------------");
        String strLog = "@Before:log Ending method: " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
        System.out.println("@Before：参数为：" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + joinPoint.getTarget());
        System.out.println(strLog);

        if (Arrays.toString(joinPoint.getArgs()).contains("admin")) {
            throw new RuntimeException("不可访问admin用户信息");
        }

        System.out.println("--------------beforeAdvice--------------]");
    }

    @After("commonPointCut()")
    public void afterAdvice(JoinPoint joinPoint) throws JsonProcessingException {
        System.out.println("[--------------afterAdvice--------------");
        String strLog = "@After:log Ending method: " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
        System.out.println(strLog);
        System.out.println("--------------afterAdvice--------------]");
    }

    @Around("commonPointCut()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("[--------------aroundAdvice--------------");

        if (Arrays.toString(proceedingJoinPoint.getArgs()).contains("admin")) {
            System.out.println("不可访问admin用户信息");
        }else {
            //打印用户信息
            User user = (User) proceedingJoinPoint.proceed();
            //change user's info , set id
            synchronized (this) {
                user.setId(userId++);
            }

            System.out.println("当前用户信息为: " + new ObjectMapper().writeValueAsString(user));
        }

        System.out.println("--------------aroundAdvice--------------]");
    }

    @AfterReturning(value = "commonPointCut()", returning = "returnValue")
    public void afterReturningAdvice(JoinPoint point, Object returnValue) throws JsonProcessingException {
        System.out.println("[--------------afterReturningAdvice--------------");
        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());
        System.out.println("@AfterReturning：方法执行返回值为:" + new ObjectMapper().writeValueAsString(returnValue));
        System.out.println("--------------afterReturningAdvice--------------]");
    }

    @AfterThrowing(value = "commonPointCut()", throwing = "e")
    public void afterThrowingAdvice(JoinPoint joinPoint, RuntimeException e) throws JsonProcessingException {
        System.out.println("[--------------afterThrowingAdvice--------------");
        String strLog = "@After-throwing:log Throwing method: " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
        System.out.println("@After-throwing: 出现异常为: " + e.getMessage());
        System.out.println(strLog);
        System.out.println("--------------afterThrowingAdvice--------------]");
    }

}
