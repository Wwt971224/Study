package com.lexue.study.other;

import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CircleTest {

    static Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    public static void main(String[] args) throws Exception {
        System.out.println(getBean(A.class).getB());
        System.out.println(getBean(B.class).getA());
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> beanClass) throws Exception {
        String simpleName = beanClass.getSimpleName();
        if (singletonObjects.containsKey(simpleName)) {

            return  (T) singletonObjects.get(simpleName);
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


}

@Getter
class A {

    private B b;
}

@Getter
class B {

    private A a;

}
