package com.lexue.study.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        shuffle(list);
        System.out.println(list);

    }

    public static <T> void shuffle(List<T> list) {
        Random random = new Random();
        for (int i = 1; i < list.size(); i++) {
            int r1 = random.nextInt(i);
            int j1 = i;
            System.out.print("r1 = " + r1);
            System.out.println(" j1 = " + j1);
            list.set(r1, list.set(j1, list.get(r1)));
        }
    }
}
