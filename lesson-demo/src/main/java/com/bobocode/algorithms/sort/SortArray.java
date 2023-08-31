package com.bobocode.algorithms.sort;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] arr = {34,45,123,22,345,55};
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------");
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            j = i - 1;
            var tmp = arr[i];
            while (j >= 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = tmp;
        }
    }

}
