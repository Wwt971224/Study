package com.lexue.study.design_pattern;

/**
 * 策略模式
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        StrategyContext strategyContext;

        strategyContext = new StrategyContext(new ConcreteStrategyA());
        strategyContext.strategyMethod();

        strategyContext = new StrategyContext(new ConcreteStrategyB());
        strategyContext.strategyMethod();

    }

}

interface Strategy {
    void strategyMethod();
}

class ConcreteStrategyA implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("ConcreteStrategyA is working");
    }
}

class ConcreteStrategyB implements Strategy {

    @Override
    public void strategyMethod() {
        System.out.println("ConcreteStrategyB is working");
    }
}

class StrategyContext {

    private final Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }

}


