package com.movit.util;

import com.movit.annotation.Controller;
import com.movit.annotation.Repository;
import com.movit.annotation.Service;

import java.util.HashSet;
import java.util.Set;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 17:44
 ************************************************************/

public class ClassHelper {
    private static final Set<Class<?>> CLASSES;

    static {
        CLASSES = ClassUtil.getClassSet("com.movit");
    }

    public static Set<Class<?>> getClasses() {
        return CLASSES;
    }

    public static Set<Class<?>> getControllerClasses() {
        Set<Class<?>> controllerClasses = new HashSet<Class<?>>();
        if (CLASSES != null && CLASSES.size() > 0) {
            for (Class<?> clazz: CLASSES) {
                if (clazz.isAnnotationPresent(Controller.class)) {
                    controllerClasses.add(clazz);
                }
            }
        }
        return controllerClasses;
    }

    public static Set<Class<?>> getServiceClasses() {
        Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
        if (CLASSES != null && CLASSES.size() > 0) {
            for (Class<?> clazz: CLASSES) {
                if (clazz.isAnnotationPresent(Service.class)) {
                    serviceClasses.add(clazz);
                }
            }
        }
        return serviceClasses;
    }

    public static Set<Class<?>> getRepositoryClasses() {
        Set<Class<?>> repositoryClasses = new HashSet<Class<?>>();
        if (CLASSES != null && CLASSES.size() > 0) {
            for (Class<?> clazz: CLASSES) {
                if (clazz.isAnnotationPresent(Repository.class)) {
                    repositoryClasses.add(clazz);
                }
            }
        }
        return repositoryClasses;
    }
}
