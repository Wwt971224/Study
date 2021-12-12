package com.lexue.study.algorithm;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        int[] arr = {8, 4, 9, 6, 7, 2, 0, 1, 3, 5};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        for (int gap = arr.length >> 1; gap > 0; gap = gap >> 1) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                if (arr[j] < arr[j - gap]) {
                    int temp = arr[j];
                    while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }


}
