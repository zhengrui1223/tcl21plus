package com.movit.study.spring.transaction.demo_my;

import org.springframework.core.NamedThreadLocal;

public class MyTransactionResourceManager {

    private static ThreadLocal resources = new NamedThreadLocal("Transactional resources");

    public static Object getResource(){
        return resources.get();
    }

    public static void bindResource(Object resource) {
        resources.set(resource);
    }

    public static Object unbindResource() {
        Object resource = getResource();
        resources.set(null);
        return resource;
    }

}
