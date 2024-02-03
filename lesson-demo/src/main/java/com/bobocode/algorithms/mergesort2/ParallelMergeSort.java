package com.bobocode.algorithms.mergesort2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort {

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(List.of(5, 7, 8, 4, 2, 3, 1, 6, 10));
        System.out.println(Arrays.toString(elements.toArray()));

        try (ForkJoinPool forkJoinPool = ForkJoinPool.commonPool()) {
            forkJoinPool.submit(new MergeSortRecursiveAction<>(elements)).join();
        }

        System.out.println(Arrays.toString(elements.toArray()));
    }

}
