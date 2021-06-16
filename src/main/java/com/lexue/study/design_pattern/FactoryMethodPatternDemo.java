package com.lexue.study.design_pattern;

/**
 * 工厂方法模式
 */
public class FactoryMethodPatternDemo {

    interface Product {
        void show();
    }

    public static class ConcreteProduct1 implements Product {

        @Override
        public void show() {
            System.out.println("ConcreteProduct1 is show");
        }
    }

    public static class ConcreteProduct2 implements Product {

        @Override
        public void show() {
            System.out.println("ConcreteProduct2 is show");
        }
    }

    interface AbstractFactory {
        Product newProduct();
    }

    public static class ConcreteFactory1 implements AbstractFactory {
        @Override
        public Product newProduct() {
            System.out.println("ConcreteFactory1 build ConcreteProduct1");
            return new ConcreteProduct1();
        }
    }

    public static class ConcreteFactory2 implements AbstractFactory {

        @Override
        public Product newProduct() {
            System.out.println("ConcreteFactory2 build ConcreteProduct2");
            return new ConcreteProduct2();
        }
    }

    public static void main(String[] args) {
        AbstractFactory concreteFactory1 = new ConcreteFactory1();
        concreteFactory1.newProduct().show();

        AbstractFactory concreteFactory2 = new ConcreteFactory2();
        concreteFactory2.newProduct().show();

    }


}

