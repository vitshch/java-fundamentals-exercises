package com.bobocode.algorithms.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSortDemo {

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(List.of(6, 3, 4, 2, 1));
        System.out.println(Arrays.toString(elements.toArray()));

        ForkJoinPool.commonPool().submit(new MergeSortRecursiveAction<>(elements)).join();

        System.out.println(Arrays.toString(elements.toArray()));
    }

}
