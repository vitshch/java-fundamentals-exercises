package com.bobocode.algorithms;

import java.util.Arrays;

public class MergeSortDemo2 {

    public static void main(String[] args) {
        int[] elements = {7, 3, 4, 9, 2, 6, 5, 8, 1, 10};
        System.out.println(Arrays.toString(elements));
        System.out.println();
        int[] sortedElements = sort(elements);
        System.out.println(Arrays.toString(sortedElements));
    }

    private static int[] sort(int[] elements) {
        if (elements.length < 2) {
            return elements;
        }
        var half = elements.length / 2;
        var left = sort(Arrays.copyOfRange(elements, 0, half));
        var right = sort(Arrays.copyOfRange(elements, half, elements.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int lp = 0, rp = 0, mp = 0;
        int leftSize = left.length;
        int rightSize = right.length;
        int[] merged = new int[leftSize + rightSize];

        while (lp < leftSize && rp < rightSize) {
            if (left[lp] < right[rp]) {
                merged[mp] = left[lp];
                lp++;
            } else {
                merged[mp] = right[rp];
                rp++;
            }
            mp++;
        }

        System.arraycopy(left, lp, merged, mp, leftSize - lp);
        System.arraycopy(right, rp, merged, mp, rightSize - rp);
        return merged;
    }

}
