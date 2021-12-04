package com.lexue.study.spring.config;

import com.alibaba.fastjson.JSON;
import com.lexue.study.spring.bean.E;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        System.out.println("BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");
        System.out.println(JSON.toJSONString(beanDefinitionNames));
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(E.class).getBeanDefinition();
        registry.registerBeanDefinition("e", beanDefinition);
        String[] beanDefinitionNames1 = registry.getBeanDefinitionNames();
        System.out.println(JSON.toJSONString(beanDefinitionNames1));

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
