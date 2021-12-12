package com.lexue.study.other;

import com.lexue.study.spring.bean.D;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setAb(new AB());
        Dog targetProxy = (Dog) new MyMethodInterceptor(dog).getTargetProxy();
        targetProxy.eat();
        System.out.println(dog.getAb());
        System.out.println(targetProxy.getAb());
        System.out.println(targetProxy.getAb());
    }
}

class Dog {

    public AB ab;

    public void eat() {
        System.out.println("狗---------eat");
    }

    public AB getAb() {
        return ab;
    }

    public void setAb(AB ab) {
        this.ab = ab;
    }
}

class AB {

}

class MyMethodInterceptor implements MethodInterceptor {
    Object target;

    public MyMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("这里是对目标类进行增强！！！");
        //注意这里的方法调用，不是用反射哦！！！
        Object object = proxy.invokeSuper(obj, args);
        return object;
    }
    public Object getTargetProxy() {
        // Enhancer类是cglib中的一个字节码增强器，它可以方便的为你所要处理的类进行扩展
        Enhancer eh = new Enhancer();
        // 1.将目标对象所在的类作为Enhancer类的父类
        eh.setSuperclass(target.getClass());
        // 2.通过实现MethodInterceptor实现方法回调
        eh.setCallback(this);
        // 3. 创建代理实例
        return eh.create();
    }
}
