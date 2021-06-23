package com.lexue.study.design_pattern;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * 责任链模式
 */
public class ChainOfResponsibilityDemo {

    @Data
    abstract static class Handler {

        private Handler nextHandler;

        public abstract void handleRequest(String request);

    }

    static class ConcreteHandler1 extends Handler {

        @Override
        public void handleRequest(String request) {
            if ("one".equals(request)) {
                System.out.println("ConcreteHandler1 is working! ");
            } else {
                if (Objects.nonNull(getNextHandler())) {
                    getNextHandler().handleRequest(request);
                } else {
                    System.out.println("no Handler ask request");
                }
            }
        }
    }

    static class ConcreteHandler2 extends Handler {

        @Override
        public void handleRequest(String request) {
            if ("two".equals(request)) {
                System.out.println("ConcreteHandler2 is working! ");
            } else {
                if (Objects.nonNull(getNextHandler())) {
                    getNextHandler().handleRequest(request);
                } else {
                    System.out.println("no Handler ask request");
                }
            }
        }
    }

    static class HandlerContext {

        private static final Handler handler;

        static {
            List<Handler> handlers = Lists.newArrayList(new ConcreteHandler1(), new ConcreteHandler2());
            for (int i = 1; i < handlers.size(); i++) {
                handlers.get(i - 1).setNextHandler(handlers.get(i));
            }
            handler = handlers.get(0);
        }

        public static void handle(String request) {
            handler.handleRequest(request);
        }

    }


    public static void main(String[] args) {
        HandlerContext.handle("two");
    }

}


