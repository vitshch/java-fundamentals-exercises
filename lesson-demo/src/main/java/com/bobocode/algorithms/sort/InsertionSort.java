package com.bobocode.algorithms.sort;

/**
 * InsertionSort
 *
 * Complexity: O(n^2)
 */

public class InsertionSort {

    public static void sort(int[] arr) {
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
