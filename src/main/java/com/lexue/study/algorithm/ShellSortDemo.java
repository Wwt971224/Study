package com.lexue.study.algorithm;

import java.util.Arrays;

public class ShellSortDemo {

    public static void main(String[] args) {
        int[] arr = {8, 4, 9, 6, 7, 2, 0, 1, 3, 5};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void shellSort(int[] arr) {
        for (int gap = arr.length >> 1; gap > 0; gap = gap >> 1) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }

//                for (int j = i; j>=gap; j-=gap) {
//                    if (arr[j] < arr[j - gap]) {
//                        int temp = arr[j];
//                        arr[j] = arr[j - gap];
//                        arr[j - gap] = temp;
//                    }
//                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

}
