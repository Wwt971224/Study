package com.lexue.study.other;


import com.alibaba.fastjson.JSON;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.HashMap;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
//        HashMap<String, String> map = new HashMap<>();
//        map.put("1", "1");
//        map.put("2", "2");

        ArrayDeque<Object> arrayQueue = new ArrayDeque<>(8);
        arrayQueue.addFirst("a");
        arrayQueue.addFirst("b");
        arrayQueue.addFirst("c");
        arrayQueue.addFirst("d");

        arrayQueue.addLast("e");
        arrayQueue.addLast("f");
        arrayQueue.addLast("g");
        arrayQueue.addLast("h");

//        arrayQueue.forEach();

        System.out.println(JSON.toJSONString(arrayQueue));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
