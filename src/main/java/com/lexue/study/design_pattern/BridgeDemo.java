package com.lexue.study.design_pattern;

/**
 * 桥接模式
 */
public class BridgeDemo {

    interface Implementor {
        void OperationImpl();
    }

    static class ConcreteImplementorA implements Implementor {
        public void OperationImpl() {
            System.out.println("具体实现化(Concrete Implementor)角色被访问");
        }
    }


    abstract static class Abstraction {
        protected Implementor implementor;

        protected Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }

        public abstract void Operation();

    }

    static class RefinedAbstraction extends Abstraction {
        protected RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void Operation() {
            System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
            implementor.OperationImpl();
        }
    }

    public static void main(String[] args) {
        ConcreteImplementorA concreteImplementorA = new ConcreteImplementorA();
        Abstraction refinedAbstraction = new RefinedAbstraction(concreteImplementorA);
        refinedAbstraction.Operation();
    }

}
