package com.lexue.study.design_pattern;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 构造者模式
 */
public class BuilderDemo {

    @ToString
    @Setter
    static class Product {

        private String partA;

        private String partB;

        private String partC;

        public void show() {
            System.out.println(this);
        }

    }

    abstract static class Build {

        protected Product product = new Product();

        abstract public void buildPartA();

        abstract public void buildPartB();

        abstract public void buildPartC();

        public Product getResult() {
            return product;
        }

    }

    static class ConcreteBuild1 extends Build {
        @Override
        public void buildPartA() {
            product.setPartA("build partA");
        }

        @Override
        public void buildPartB() {
            product.setPartB("build partB");
        }

        @Override
        public void buildPartC() {
            product.setPartC("build partC");
        }
    }

    static class ConcreteBuild2 extends Build {

        @Override
        public void buildPartA() {

        }

        @Override
        public void buildPartB() {

        }

        @Override
        public void buildPartC() {

        }
    }


    @AllArgsConstructor
    public static class Director {

        private final Build build;

        public Product construct() {
            build.buildPartA();
            build.buildPartB();
            build.buildPartC();
            return build.getResult();
        }
    }

    public static void main(String[] args) {
        new Director(new ConcreteBuild1()).construct().show();
    }


}
