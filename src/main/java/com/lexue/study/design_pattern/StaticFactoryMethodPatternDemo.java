package com.lexue.study.design_pattern;

/**
 * 静态工厂模式
 */
public class StaticFactoryMethodPatternDemo {

    interface Product {
        void show();
    }

    static class ConcreteProduct1 implements Product {

        @Override
        public void show() {
            System.out.println("ConcreteProduct1 is show");
        }
    }

    static class ConcreteProduct2 implements Product {

        @Override
        public void show() {
            System.out.println("ConcreteProduct2 is show");
        }
    }

    static class SimpleFactory {
        public static Product makeProduct(int kind) {
            switch (kind) {
                case Const.PRODUCT_A:
                    return new ConcreteProduct1();
                case Const.PRODUCT_B:
                    return new ConcreteProduct2();
                default:
                    return null;
            }
        }
    }

    interface Const {
        int PRODUCT_A = 0;
        int PRODUCT_B = 1;
        int PRODUCT_C = 2;
    }

    public static void main(String[] args) {
        Product product1 = SimpleFactory.makeProduct(Const.PRODUCT_A);
        assert product1 != null;
        product1.show();
        Product product2 = SimpleFactory.makeProduct(Const.PRODUCT_B);
        assert product2 != null;
        product2.show();
        Product product3 = SimpleFactory.makeProduct(Const.PRODUCT_C);
        assert product3 != null;
        product3.show();
    }


}
