package com.bobocode;

import java.util.Arrays;

public class MergeSort1 {

    public static void main(String[] args) {
        int[] arr = {5, 63, 34, 1, 78};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        System.out.println(Arrays.toString(arr));
    }
}
