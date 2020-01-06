package com.movit.study.spring.enable.server.impl;

import com.movit.study.spring.enable.server.impl.ServerImportSelector;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/************************************************************
 * @Description: TODO
 * @Author: zhengrui
 * @Date 2019-12-26 14:41
 ************************************************************/

public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        ServerImportSelector selector = new ServerImportSelector();
        String[] selectedClassNames = selector.selectImports(importingClassMetadata);

        Stream.of(selectedClassNames)
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition -> BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry));

    }
}
