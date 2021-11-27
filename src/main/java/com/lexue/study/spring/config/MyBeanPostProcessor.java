package com.lexue.study.spring.config;

import com.lexue.study.spring.bean.A;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.Resource;

//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Resource
    private A a;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization" + "- " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization" + "- " + beanName);
        return bean;
    }
}
