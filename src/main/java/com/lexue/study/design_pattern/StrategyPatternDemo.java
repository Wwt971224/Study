package com.lexue.study.design_pattern;

/**
 * 策略模式
 */
public class StrategyPatternDemo {


    interface Strategy {
        void strategyMethod();
    }

    static class ConcreteStrategyA implements Strategy {

        @Override
        public void strategyMethod() {
            System.out.println("ConcreteStrategyA is working");
        }
    }

    static class ConcreteStrategyB implements Strategy {

        @Override
        public void strategyMethod() {
            System.out.println("ConcreteStrategyB is working");
        }
    }

    static class StrategyContext {

        private final Strategy strategy;

        public StrategyContext(Strategy strategy) {
            this.strategy = strategy;
        }

        public void strategyMethod() {
            strategy.strategyMethod();
        }

    }

    public static void main(String[] args) {
        System.out.println("1");
        System.out.println("2");
        System.out.println("4");
        StrategyContext strategyContext;

        strategyContext = new StrategyContext(new ConcreteStrategyA());
        strategyContext.strategyMethod();

        strategyContext = new StrategyContext(new ConcreteStrategyB());
        strategyContext.strategyMethod();

    }

}



