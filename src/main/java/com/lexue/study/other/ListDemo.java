package com.lexue.study.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;

public class ListDemo {

    public static void main(String[] args) {
//        List<String> names = new ArrayList<String>(){{
//            add("Tom");
//            add("Sally");
//            add("John");
//        }};
//
//        List<String> strings = Arrays.asList("1");
//        System.out.println(strings.toArray().getClass() == Object[].class);
//        System.out.println(strings.toArray().getClass() == String[].class);
//        ArrayList<String> strings1 = new ArrayList<>(Arrays.asList("1"));
//        System.out.println(strings1.toArray().getClass() == Object[].class);
//        System.out.println(names);
//        ArrayList<Object> objects = new ArrayList<>(1);
//        objects.add(1);
//        System.out.println("objects.size() = " + objects.size());
//        objects.add(2);
//        System.out.println("objects.size() = " + objects.size());

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] newArr = new int[a.length + (a.length >> 1)];
        System.arraycopy(a, 0, newArr, 2, a.length);
        System.out.println(Arrays.toString(newArr));
//        int[] b = new int[11];
//        System.arraycopy(a, 0, b, 0, a.length);
//        a = b;
//        System.out.println(Arrays.toString(a));
//        System.arraycopy(a, 1, a, 2, a.length-2);
//        System.out.println(Arrays.toString(a));


//        ArrayList<Object> objects = new ArrayList<>(Arrays.asList(0, 1, 3));
//        objects.add(2,2);
//        objects.remove(2);
//        System.out.println(objects);

        ArrayList<Integer> list = new ArrayList<Integer>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            list.add(0, i);
        }
        ListIterator<Integer> integerListIterator = list.listIterator();
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("耗时：" + (endTime1 - startTime));
//        LinkedList<Integer> list2 = new LinkedList<Integer>();
//        for (int i = 0; i < 100; i++) {
//            list2.addFirst(i);
//        }
//        System.out.println("耗时：" + (System.currentTimeMillis() - endTime1));
    }


}
