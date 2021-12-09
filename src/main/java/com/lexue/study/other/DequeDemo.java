package com.lexue.study.other;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DequeDemo {

    public static void main(String[] args) {
//        System.out.println(-2&7);
//        ArrayDeque<String> deque = new ArrayDeque<>(1);
//        deque.push("a");
//        deque.push("b");
//        deque.push("c");
//        deque.push("d");
//        deque.offerLast("e");
//        deque.offerLast("f");
//        deque.offerLast("g");
//        deque.offerLast("h");
//        deque.push("i");
//        deque.offerLast("j");
//
//        System.out.println(deque);
        testDeque();
    }

    static void testDeque() {

        int head = 0;
        int tail = 0;
        Object[] elements = new Object[8];
        // 头插入
        elements[head = (head - 1) & (elements.length - 1)] = "a";
        elements[head = (head - 1) & (elements.length - 1)] = "b";
        elements[head = (head - 1) & (elements.length - 1)] = "c";
        elements[head = (head - 1) & (elements.length - 1)] = "d";
        // 尾插入
        elements[tail] = "e";
        tail = (tail + 1) & (elements.length - 1);
        elements[tail] = "f";
        tail = (tail + 1) & (elements.length - 1);
        elements[tail] = "g";
        tail = (tail + 1) & (elements.length - 1);
        elements[tail] = "h";
        tail = (tail + 1) & (elements.length - 1);
        System.out.println(Arrays.toString(elements));
        // 当head = tail的时候需要扩容
        Object[] a = new Object[elements.length << 1];
        System.arraycopy(elements, head, a, 0, elements.length - head);
        System.arraycopy(elements, 0, a, elements.length - head, head);
        tail = elements.length;
        head = 0;
        elements = a;
        System.out.println(Arrays.toString(elements));
        // 头插入
        elements[head = (head - 1) & (elements.length - 1)] = "i";
        // 尾插入
        elements[tail] = "j";
        tail = (tail + 1) & (elements.length - 1);
        System.out.println(Arrays.toString(elements));
        // 头出栈
        do {
            if (elements[head] != null) {
                System.out.print(elements[head] + " ");
                head = (head + 1) & (elements.length - 1);
            }
        } while (head != tail);
        System.out.println();
        // 尾出栈
        head = elements.length - 1;
        tail = tail - 1;
        do {
            if (elements[tail] != null) {
                System.out.print(elements[tail] + " ");
                tail = (tail - 1) & (elements.length - 1);
            }
        } while (tail != head + 1);


//        int head = 0;
//        int tail = 0;
//        Object[] elements = new Object[8];
//        elements[head = (head - 1) & (elements.length - 1)] = "a";
//        elements[head = (head - 1) & (elements.length - 1)] = "b";
//        elements[head = (head - 1) & (elements.length - 1)] = "c";
//        elements[head = (head - 1) & (elements.length - 1)] = "d";
//        elements[tail] = "e";
//        tail = (tail + 1) & (elements.length - 1);
//        elements[tail] = "f";
//        tail = (tail + 1) & (elements.length - 1);
//        elements[tail] = "g";
//        tail = (tail + 1) & (elements.length - 1);
//        elements[tail] = "h";
//        tail = (tail + 1) & (elements.length - 1);
//        System.out.println(Arrays.toString(elements));
//        System.out.println("head = " + head);
//        System.out.println("tail = " + tail);
//        // 扩容
//        int p = head;
//        int n = elements.length;
//        int r = n - p;
//        Object[] a = new Object[n << 1];
//        System.arraycopy(elements, p, a, 0, r);
//        System.arraycopy(elements, 0, a, r, p);
//        System.out.println(Arrays.toString(a));
//        elements = a;
//        head = 0;
//        tail = n;
//        elements[head = (head - 1) & (elements.length - 1)] = "i";
//        elements[tail] = "j";
//        tail = (tail + 1) & (elements.length - 1);
//        System.out.println(Arrays.toString(elements));
//        System.out.println("head = " + head);
//        System.out.println("tail = " + tail);
//
//        elements[head = (head - 1) & (elements.length - 1)] = "k";
//        elements[head = (head - 1) & (elements.length - 1)] = "l";
//        elements[head = (head - 1) & (elements.length - 1)] = "m";
//        elements[head = (head - 1) & (elements.length - 1)] = "n";
//        elements[head = (head - 1) & (elements.length - 1)] = "o";
//        elements[head = (head - 1) & (elements.length - 1)] = "p";
//        System.out.println(Arrays.toString(elements));
//        System.out.println("head = " + head);
//        System.out.println("tail = " + tail);
//        // 扩容
//        int p1 = head;
//        int n1 = elements.length;
//        int r1 = n1 - p1;
//        Object[] b = new Object[n1 << 1];
//        System.arraycopy(elements, head, b, 0, r1);
//        System.arraycopy(elements, 0, b, r1, p1);
//        elements = b;
//        head = 0;
//        tail = n1;
//        System.out.println(Arrays.toString(elements));
//        System.out.println("head = " + head);
//        System.out.println("tail = " + tail);
//
//        elements[head = (head - 1) & (elements.length - 1)] = "q";
//        elements[tail] = "r";
//        tail = (tail + 1) & (elements.length - 1);
//        System.out.println(Arrays.toString(elements));
//        System.out.println("head = " + head);
//        System.out.println("tail = " + tail);


    }
}
