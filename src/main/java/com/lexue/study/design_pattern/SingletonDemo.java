package com.lexue.study.design_pattern;

import java.util.Objects;

/**
 * 单例模式
 */
public class SingletonDemo {

    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        hungrySingleton.showMessage();
        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.showMessage();
    }

}

class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    public void showMessage() {
        System.out.println("hungrySingleton say 'Hello World'");
    }

}

class LazySingleton {

    private static volatile LazySingleton lazySingleton;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (Objects.isNull(lazySingleton)) {
            synchronized (LazySingleton.class) {
                if (Objects.isNull(lazySingleton)) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    public void showMessage() {
        System.out.println("lazySingleton say 'Hello World'");
    }

}
