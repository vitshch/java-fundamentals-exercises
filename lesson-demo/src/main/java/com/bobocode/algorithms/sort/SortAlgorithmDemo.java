package com.bobocode.algorithms.sort;

import java.util.Arrays;

public class SortAlgorithmDemo {

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 5, 6};

//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(arr);

//        InsertionSort insertionSort = new InsertionSort();
//        insertionSort.sort(arr);

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
