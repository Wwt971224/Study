package com.lexue.study.design_pattern;

/**
 * 外观模式
 */
public class FacadeDemo {

    static class SubSystem1 {

        public void method1() {
            System.out.println("SubSystem1.method1 is running");
        }
    }

    static class SubSystem2 {

        public void method2() {
            System.out.println("SubSystem2.method2 is running");
        }
    }

    static class SubSystem3 {

        public void method3() {
            System.out.println("SubSystem3.method3 is running");
        }
    }

    static class Facade {

        private final SubSystem1 subSystem1 = new SubSystem1();
        private final SubSystem2 subSystem2 = new SubSystem2();
        private final SubSystem3 subSystem3 = new SubSystem3();

        public void method() {
            subSystem1.method1();
            subSystem2.method2();
            subSystem3.method3();
        }

    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }

}
