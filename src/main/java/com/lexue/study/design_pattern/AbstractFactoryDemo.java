package com.lexue.study.design_pattern;

public class AbstractFactoryDemo {

    interface Product1 {

        void show();
    }

    interface Product2 {

        void work();
    }

    public static class ConcreteProductA1 implements Product1 {

        @Override
        public void show() {
            System.out.println("ConcreteProduct11 is showing");
        }
    }

    public static class ConcreteProductA2 implements Product1 {

        @Override
        public void show() {
            System.out.println("ConcreteProduct12 is showing");
        }
    }

    public static class ConcreteProductB1 implements Product2 {

        @Override
        public void work() {
            System.out.println("ConcreteProduct21 is working");
        }
    }

    public static class ConcreteProductB2 implements Product2 {

        @Override
        public void work() {
            System.out.println("ConcreteProduct22 is working");
        }
    }

    interface AbstractFactory {

        Product1 newProduct1();

        Product2 newProduct2();
    }

    public static class ConcreteFactory1 implements AbstractFactory {

        @Override
        public Product1 newProduct1() {
            return new ConcreteProductA1();
        }

        @Override
        public Product2 newProduct2() {
            return new ConcreteProductB1();
        }
    }

    public static class ConcreteFactory2 implements AbstractFactory {

        @Override
        public Product1 newProduct1() {
            return new ConcreteProductA2();
        }

        @Override
        public Product2 newProduct2() {
            return new ConcreteProductB2();
        }
    }

    public static void main(String[] args) {
        AbstractFactory concreteFactory1 = new ConcreteFactory1();
        concreteFactory1.newProduct1().show();
        concreteFactory1.newProduct2().work();
        AbstractFactory concreteFactory2 = new ConcreteFactory2();
        concreteFactory2.newProduct1().show();
        concreteFactory2.newProduct2().work();
    }


}
