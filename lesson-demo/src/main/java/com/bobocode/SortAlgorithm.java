package com.bobocode;

public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1};
        sort(arr);
        for (int item : arr) {
            System.out.print(item + ", ");
        }
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

}
