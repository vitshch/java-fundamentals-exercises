package com.bobocode.algorithms;

import java.util.Arrays;

public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {2, 8, 6, 5, 7, 3, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {
        var length = arr.length;
        if (length == 1) {
            return arr;
        }
        var size = length / 2;

        int[] left = sort(Arrays.copyOfRange(arr, 0, size));
        int[] right = sort(Arrays.copyOfRange(arr, size, length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, k = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                result[k] = left[l++];
            } else {
                result[k] = right[r++];
            }
            k++;
        }
//
//        while (l < left.length) {
//            result[k++] = left[l++];
//        }
//        while (r < right.length) {
//            result[k++] = right[r++];
//        }
//
        System.arraycopy(left, l, result, l + r, left.length - l);
        System.arraycopy(right, r, result, l + r, right.length - r);

        return result;
    }
}
