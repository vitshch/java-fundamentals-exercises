package com.bobocode.algorithms.sort;

import java.util.Arrays;

/**
 * BRING SYNC 4 | TASK 0
 * 👉 Implement your sorting algorithms
 * <p>
 * Implement all sorting algorithms you can recall
 * create simple methods accepting an int array for each algorithms
 * add javadoc specifying algorithm features, like time complexity and other details
 * Prep a simple demo showing those methods work
 * Post  screenshots of your code in the Thread 👇
 */
public class SortingAlgorithmsDemo {

    public static void main(String[] args) {
        int[] arr = {2, 8, 6, 5, 7, 3, 1};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("------------------------");
        int[] arr2 = new int[]{2, 8, 6, 5, 7, 3, 1};
        InsertionSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));

    }

}
