package com.bobocode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSortDemo1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 6, 3, 2, 1, 0, 4, 110));
        System.out.println(list);
        System.out.println("------------------");
        sort(list);
        System.out.println(list);
    }

    private static <T extends Comparable<T>> void sort(List<T> list) {
        var length = list.size();
        if (length == 1) {
            return;
        }
        var size = length / 2;

        List<T> left = new ArrayList<>(list.subList(0, size));
        List<T> right = new ArrayList<>(list.subList(size, length));

        sort(left);
        sort(right);

        merge(list, left, right);
    }

    private static <T extends Comparable<T>> void merge(List<T> list, List<T> left, List<T> right) {
        System.out.println("List: " + list);
        System.out.println("Left: " + left);
        System.out.println("Right: " + right);

        int l = 0, r = 0, k = 0;

        while (l < left.size() && r < right.size()) {
            if (left.get(l).compareTo(right.get(r)) < 0) {
                list.set(k++, left.get(l++));
            } else {
                list.set(k++, right.get(r++));
            }
        }
        while (l < left.size()) {
            list.set(k++, left.get(l++));
        }
        while (r < right.size()) {
            list.set(k++, right.get(r++));
        }
        System.out.println("Sorted: " + list);
        System.out.println("----------------------");
    }

}
