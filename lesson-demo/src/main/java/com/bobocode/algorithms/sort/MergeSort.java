package com.bobocode.algorithms.sort;

import java.util.Arrays;

// TODO: 11/12/2023
public class MergeSort {

    public static int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int size = arr.length / 2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, size));
        int[] right = sort(Arrays.copyOfRange(arr, size, 0));

//        return merge(left, right);
        return null;
    }

//    private static int[] merge(int[] left, int[] right) {
//        int l = 0, r = 0, k = 0;
//
//        while ()
//    }

}
