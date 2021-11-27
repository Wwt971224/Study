package com.lexue.study.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.BindException;
import java.util.*;

public class TestDemo {

    private List<Integer> list = new ArrayList<>();
    int x1 = 0;
    int x2 = 0;
    int x3 = 0;
    int x4 = 0;
    int x5 = 0;

    @Before
    public void init() {
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        System.out.println("over");
    }

    public void test_LinkedList_for0() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            x1 += list.get(i);
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
    }

    public void test_LinkedList_for1() {
        long startTime = System.currentTimeMillis();
        for (Integer itr : list) {
            x2 += itr;
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
    }

    public void test_LinkedList_Iterator() {

        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            x3 += next;
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
    }

    public void test_LinkedList_forEach() {
        long startTime = System.currentTimeMillis();
        list.forEach(integer -> {
            x4 += integer;
        });
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
    }


    public void test_LinkedList_stream() {
        long startTime = System.currentTimeMillis();
        list.stream().forEach(integer -> {
            x5 += integer;
        });
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
//        integers.forEach(String::valueOf);

//        test_LinkedList_for0();
        test_LinkedList_for1();
        test_LinkedList_Iterator();
        test_LinkedList_forEach();
        test_LinkedList_stream();
    }

    @Test
    public void test_arraycopy() {
        int head = 0;
        int tail = 0;
        Object[] element = new Object[8];

        element[head = (head - 1) & (element.length - 1)] = "a";
        element[head = (head - 1) & (element.length - 1)] = "b";
        element[head = (head - 1) & (element.length - 1)] = "c";
        element[head = (head - 1) & (element.length - 1)] = "d";

        element[tail] = "e";
        tail = (tail + 1) & (element.length - 1);
        element[tail] = "f";
        tail = (tail + 1) & (element.length - 1);
        element[tail] = "g";
        tail = (tail + 1) & (element.length - 1);
        element[tail] = "h";
        tail = (tail + 1) & (element.length - 1);
        System.out.println("head = " + head);
        System.out.println("tail = " + tail);
        int p = head;
        int n = element.length;
        int r = n - p;
        System.out.println(JSON.toJSONString(element));
        Object[] a = new Object[element.length << 1];

        System.arraycopy(element, p, a, 0, r);
        System.out.println(JSON.toJSONString(a));

        System.arraycopy(element, 0, a, r, p);
        System.out.println(JSON.toJSONString(a));

        element = a;
        head = 0;
        tail = n;
        a[head = (head - 1) & (element.length - 1)] = "i";
        a[tail] = "j";
        tail = (tail + 1) & (element.length - 1);

        System.out.println(JSON.toJSONString(a));

        System.out.println("===================================");

        do {
            if (element[head] != null) {
                System.out.print(element[head]);
                head = (head + 1) & (element.length - 1);
            }
        } while (head != tail);
    }

}
