package com.lexue.study.other;

import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CircleTest {

    static Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
    static Map<String, Object> earlyObjects = new ConcurrentHashMap<>(16);

    public static void main(String[] args) throws Exception {
        System.out.println(getBeanV2(A.class).getB());
        System.out.println(getBeanV2(B.class).getA());
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> beanClass) throws Exception {
        String simpleName = beanClass.getSimpleName();
        if (singletonObjects.containsKey(simpleName)) {

            return (T) singletonObjects.get(simpleName);
        }
        T t = beanClass.newInstance();
        singletonObjects.put(simpleName, t);
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            String fieldClassSimpleName = fieldClass.getSimpleName();
            field.set(t, singletonObjects.containsKey(fieldClassSimpleName) ? singletonObjects.get(fieldClassSimpleName) : getBean(fieldClass));
            field.setAccessible(false);
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBeanV2(Class<T> beanClass) throws Exception {
        String simpleName = beanClass.getSimpleName();
        Object singleton = getSingleton(simpleName);
        if (Objects.isNull(singleton)) {
            singleton = beanClass.newInstance();
            earlyObjects.put(simpleName, singleton);
            Field[] declaredFields = beanClass.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Class<?> fieldClass = field.getType();
                String fieldClassSimpleName = fieldClass.getSimpleName();
                Object fieldBean = getSingleton(fieldClassSimpleName);
                if (Objects.isNull(fieldBean)) {
                    fieldBean = getBeanV2(fieldClass);
                }
                field.set(singleton, fieldBean);
                field.setAccessible(false);
            }
            earlyObjects.remove(simpleName);
            singletonObjects.put(simpleName, singleton);
        }
        return (T) singleton;
    }

    public static Object getSingleton(String beanName) {
        Object bean;
        if ((bean = singletonObjects.get(beanName)) == null) {
            bean = earlyObjects.get(beanName);
        }
        return bean;
    }


}

@Getter
class A {

    private B b;
    private C c;
}

@Getter
class B {

    private A a;
    private C c;

}

@Getter
class C {
    private A a;
    private B b;
}
