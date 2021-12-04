package com.lexue.study.algorithm;

import java.util.Arrays;

/**
 * 归并算法-分治算法
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {8, 4, 9, 6, 7, 2, 3, 1, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);

    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            // 左边排序
            sort(arr, left, mid, temp);
            // 右边排序
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[t++] = arr[j++];
            } else {
                temp[t++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        for (int k = left; k <= right; k++) {
            arr[k] = temp[t++];
        }
    }


}
