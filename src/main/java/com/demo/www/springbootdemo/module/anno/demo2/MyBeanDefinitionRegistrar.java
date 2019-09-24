package com.demo.www.springbootdemo.module.anno.demo2;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 根据注解参数来注册BeanDefinition
 */
public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry register) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(MyFirstAnnotation.class.getName()));
        String name = annotationAttributes.getString("name");
        Number age = annotationAttributes.getNumber("age");
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(TestEntity.class);
        genericBeanDefinition.getPropertyValues().add("name", name);
        genericBeanDefinition.getPropertyValues().add("age", age);
        BeanDefinitionHolder holder = new BeanDefinitionHolder(genericBeanDefinition, "testEntity");
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, register);
    }
}
