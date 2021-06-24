package com.lexue.study.design_pattern;

import lombok.AllArgsConstructor;
import org.checkerframework.checker.units.qual.A;

/**
 * 适配器模式
 */
public class AdapterDemo {

    interface Target {

        void request();
    }

    static class Adaptee {
        void specialRequest() {
            System.out.println("Adaptee's specialRequest");
        }
    }

    /**
     * 类适配器
     */
    static class ClassAdapter extends Adaptee implements Target {

        @Override
        public void request() {
            specialRequest();
        }
    }

    @AllArgsConstructor
    static class ObjectAdapter implements Target {

        private final Adaptee adaptee;

        @Override
        public void request() {
            adaptee.specialRequest();
        }
    }


    public static void main(String[] args) {
        System.out.println("类适配器");
        Target classAdapter = new ClassAdapter();
        classAdapter.request();
        System.out.println("===========================");
        System.out.println("对象适配器");
        Target objectAdapter = new ObjectAdapter(new Adaptee());
        objectAdapter.request();
    }
}
