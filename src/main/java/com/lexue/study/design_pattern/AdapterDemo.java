package com.lexue.study.design_pattern;

import lombok.AllArgsConstructor;

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

    /* 类适配器 */
    static class ClassAdapter extends Adaptee implements Target{

        @Override
        public void request() {
            specialRequest();
        }
    }

    /* 对象适配器 */
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
        Target classAdapterTarget = new ClassAdapter();
        classAdapterTarget.request();

        System.out.println("==============================");
        System.out.println("对象适配器");
        Adaptee adaptee = new Adaptee();
        Target objectAdapterTarget = new ObjectAdapter(adaptee);
        objectAdapterTarget.request();

    }
}
