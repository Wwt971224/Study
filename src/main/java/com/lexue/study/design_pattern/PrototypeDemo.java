package com.lexue.study.design_pattern;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 原型模式
 */
public class PrototypeDemo {


    @AllArgsConstructor
    @Data
    static class RealizeType implements Cloneable {

        private int a;

        private Integer integer;

        private List<RealizeTypePro> realizeTypePros;

        @Override
        public RealizeType clone() throws CloneNotSupportedException {
            return (RealizeType) super.clone();
        }
    }

    @AllArgsConstructor
    @Data
    static class RealizeTypePro {

        private String string;

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType realizeType = new RealizeType(200, 200, Lists.newArrayList(new RealizeTypePro("a"), new RealizeTypePro("b")));
        RealizeType clone = realizeType.clone();
        System.out.println("realizeType == clone = " + (realizeType == clone));
        System.out.println("realizeType.getA() == clone.getA() = " + (realizeType.getA() == clone.getA()));
        System.out.println("realizeType.getInteger() == clone.getInteger() = " + (realizeType.getInteger() == clone.getInteger()));
        System.out.println("realizeType.getRealizeTypePros() == clone.getRealizeTypePros() = " + (realizeType.getRealizeTypePros() == clone.getRealizeTypePros()));
    }
}
