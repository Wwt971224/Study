package com.lexue.study.design_pattern;

import java.util.Objects;

/**
 * 代理模式
 */
public class ProxyDemo {

    interface Subject {

        void request();
    }

    static class RealSubject implements Subject {

        @Override
        public void request() {
            System.out.println("visit real subject");
        }
    }

    static class Proxy implements Subject {

        private RealSubject realSubject;

        public void preRequest() {
            System.out.println("pre visit real subject");
        }

        @Override
        public void request() {
            if (Objects.isNull(realSubject)) {
                realSubject = new RealSubject();
            }
            preRequest();
            realSubject.request();
            postRequest();
        }

        public void postRequest() {
            System.out.println("post visit real subject");
        }
    }

    public static void main(String[] args) {
        Subject proxySubject = new Proxy();
        proxySubject.request();

    }

}
