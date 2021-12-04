package com.lexue.study.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
public class EFactoryBean implements FactoryBean<E> {
    @Override
    public E getObject() throws Exception {
//        InvocationHandler invocationHandler = (proxy, method, args) -> method.invoke(proxy, args);
//        return (E) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{E.class}, invocationHandler);
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return E.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public static void main(String[] args) {
        E proxy = new Proxy().getProxy(E.class);
        proxy.say();

    }

    static class Proxy implements MethodInterceptor {


        public   <T> T  getProxy(Class<T> c) {
            return (T) Enhancer.create(c, this);
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            Object invoke = methodProxy.invokeSuper(o, objects);
            System.out.println("被代理了");
            return invoke;
        }
    }



}
