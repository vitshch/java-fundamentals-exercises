package com.bobocode.algorithms.sort;

import java.util.Arrays;

public class InsertionSort1 {

    public static void main(String[] args) {
        int[] arr = {34, 45, 123, 22, 345, 55};
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------");
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int current, j;
        for (int i = 1; i < arr.length; i++) {
            current = arr[i];
            j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}
