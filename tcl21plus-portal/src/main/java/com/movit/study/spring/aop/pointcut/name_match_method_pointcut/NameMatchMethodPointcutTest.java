package com.movit.study.spring.aop.pointcut.name_match_method_pointcut;

import com.movit.study.model.User;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

public class NameMatchMethodPointcutTest {

    public static void main(String[] args) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();

        Method[] methods = User.class.getMethods();

        pointcut.setMappedNames(new String[] {"get*", "to*"});
        boolean matches = pointcut.matches(methods[0], User.class);
        System.out.println(matches);

    }

}
