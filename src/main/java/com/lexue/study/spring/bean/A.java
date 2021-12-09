package com.lexue.study.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class A implements InitializingBean, DisposableBean {

    public A() {
        System.out.println("A.A()");
    }

    private void init() {
        System.out.println("A.init()");
    }

    private void destroy1() {
        System.out.println("A.destroy1()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("A.afterPropertiesSet()");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("A.destroy()");
    }
}
