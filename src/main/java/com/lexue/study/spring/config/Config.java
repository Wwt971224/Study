package com.lexue.study.spring.config;

import com.lexue.study.spring.bean.A;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

//@Configuration
public class Config {

    @Bean(initMethod = "init",destroyMethod = "destroy1")
    public A a() {
        return new A();
    }

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new MyBeanPostProcessor();
    }

}
