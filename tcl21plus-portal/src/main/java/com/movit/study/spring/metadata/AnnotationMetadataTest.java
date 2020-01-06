package com.movit.study.spring.metadata;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Set;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-25 17:32
 ************************************************************/

@Configuration
@EnableAspectJAutoProxy
public class AnnotationMetadataTest {

    public static void main(String[] args) throws IOException {

        String name = AnnotationMetadataTest.class.getName();

        MetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(name);
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        annotationTypes.forEach(annotationType -> {
            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
            System.out.println("annotationType: " + annotationType);
            metaAnnotationTypes.forEach(metaAnnotationType -> {
                System.out.println("metaAnnotationType: " + metaAnnotationType);
            });
        });
    }

}
