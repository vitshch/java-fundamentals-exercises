package com.bobocode.sort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 3, 8, 7, 1, 5};

//        new BubbleSort().sort(arr);
        new InsertionSort().sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
