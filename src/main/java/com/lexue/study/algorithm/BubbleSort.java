package com.lexue.study.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序优化版
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 9, 6, 7, 2, 3, 1, 5};
//        int[] arr = {1, 2, 3, 4, 5, 6, 8, 7, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

}



