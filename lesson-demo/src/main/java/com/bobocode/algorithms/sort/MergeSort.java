package com.bobocode.algorithms.sort;

import java.util.Arrays;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        var merged = mergeSort(arr);
        System.out.println(Arrays.toString(merged));
        System.arraycopy(merged, 0, arr, 0, merged.length);
    }

    private int[] mergeSort(int[] arr) {
        var length = arr.length;
        if (length == 1) {
            return arr;
        }
        var size = length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, size));
        int[] right = mergeSort(Arrays.copyOfRange(arr, size, length));

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
//        while (i < left.length) {
//            result[k++] = left[i++];
//        }
//        while (j < right.length) {
//            result[k++] = right[j++];
//        }
        System.arraycopy(left, i, result, i + j, left.length - i);
        System.arraycopy(right, j, result, i + j, right.length - j);

//        System.arraycopy(leftSubArray, leftIdx, arr, leftIdx + rightIdx, leftSubArray.length - leftIdx);
//        System.arraycopy(rightSubArray, rightIdx, arr, leftIdx + rightIdx, rightSubArray.length - rightIdx);

        return result;
    }
}
