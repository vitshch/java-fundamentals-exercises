package com.bobocode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * ONLINE TRAINING 5 | TASK 0
 * 👉 Implement the Merge Sort
 * <p>
 * - Create a new project or use the existing one
 * - Implement the Merge Sort algorithm for a generic list of comparable elements
 * - Post  screenshots of your code in the Thread 👇
 */

// TODO: DECOMPOSE problem
public class MergeSortDemo0 {

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 6, 3, 2, 1, 0, 4, 110);
        List<Integer> sorted = sort(list);
        System.out.println(sorted);
    }

    private static <T extends Comparable<T>> List<T> sort(List<T> list) {
        var length = list.size();
        if (length == 1) {
            return list;
        }
        var size = length / 2;

        List<T> left = sort(list.subList(0, size));
        List<T> right = sort(list.subList(size, length));

        return merge(left, right);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int l = 0, r = 0;

        while (l < left.size() && r < right.size()) {
            if (left.get(l).compareTo(right.get(r)) < 0) {
                result.add(left.get(l++));
            } else {
                result.add(right.get(r++));
            }
        }
        while (l < left.size()) {
            result.add(left.get(l++));
        }
        while (r < right.size()) {
            result.add(right.get(r++));
        }
        return result;
    }

}
