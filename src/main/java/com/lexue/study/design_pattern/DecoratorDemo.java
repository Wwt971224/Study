package com.lexue.study.design_pattern;

import lombok.AllArgsConstructor;

/**
 * 装饰器模式
 */
public class DecoratorDemo {

    interface Component {
        void operation();
    }

    static class ConcreteComponent implements Component {

        public ConcreteComponent() {
            System.out.println("创建具体构件角色");
        }

        @Override
        public void operation() {
            System.out.println("调用具体构件角色的方法operation()");
        }
    }

    @AllArgsConstructor
    abstract static class Decorator implements Component {

        private final Component component;

        @Override
        public void operation() {
            component.operation();
        }
    }

    static class ConcreteDecorator extends Decorator {

        public ConcreteDecorator(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            addedFunction();
        }

        public void addedFunction() {
            System.out.println("为具体构件角色增加额外的功能addedFunction()");
        }
    }

    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.operation();
        System.out.println("========================================");
        Decorator concreteDecorator = new ConcreteDecorator(concreteComponent);
        concreteDecorator.operation();
    }

}
