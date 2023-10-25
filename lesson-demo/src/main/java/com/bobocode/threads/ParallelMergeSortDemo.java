package com.bobocode.threads;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 10, 7, 8, 9, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        ForkJoinPool.commonPool().invoke(new MergeSortRecursiveAction(arr));
    }

    public static void merge(int[] arr, int[] left, int[] right) {

    }
}
