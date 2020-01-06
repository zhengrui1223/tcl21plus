package com.movit.study.spring.metadata;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-25 17:32
 ************************************************************/

@Configuration(value = "hello")
public class AnnotationMetadataTest2 {

    public static void main(String[] args) throws IOException {

        AnnotatedElement annotatedElement = AnnotationMetadataTest2.class;

        Configuration annotation = annotatedElement.getAnnotation(Configuration.class);
        ReflectionUtils.doWithMethods(Configuration.class, method -> {
            System.out.println(method.getName());
            ReflectionUtils.invokeMethod(method, annotation);
        });
    }

}
