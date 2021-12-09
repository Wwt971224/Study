package com.lexue.study.algorithm;

import java.util.Arrays;

/**
 * 归并算法-分治算法
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {8, 4, 9, 6, 7, 2, 3, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
//        while (left < right) {
//            sort(arr,);
//        }
    }

}
