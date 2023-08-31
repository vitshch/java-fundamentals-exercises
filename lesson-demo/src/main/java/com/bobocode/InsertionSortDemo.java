package com.bobocode;

import java.util.Arrays;

public class InsertionSortDemo {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 1, 31, 5, 67};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            var current = arr[i];
            var j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

}
