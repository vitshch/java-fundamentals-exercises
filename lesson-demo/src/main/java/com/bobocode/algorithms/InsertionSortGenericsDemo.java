package com.bobocode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortGenericsDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(7, 5, 4, 6, 3, 1, 2));
        sort(list);
        System.out.println(list);

        List<String> stringList = new ArrayList<>(List.of("WW", "CC", "B", "A"));
        sort(stringList);
        System.out.println(stringList);
    }

    private static <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            int j = i - 1;
            var current = list.get(i);
            while (j >=0 && list.get(j).compareTo(current) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }

}
