package com.lexue.study.algorithm;

import java.util.Arrays;

/**
 * 归并算法-分治算法
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {8, 4, 9, 6, 7, 2, 1, 3, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }

    }


}
