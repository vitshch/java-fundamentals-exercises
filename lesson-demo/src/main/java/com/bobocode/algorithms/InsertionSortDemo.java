package com.bobocode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortDemo {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(List.of(7, 5, 4, 6, 3, 1, 2));
        System.out.println(integerList);
        sort(integerList);
        System.out.println(integerList);
    }

    private static <T extends Comparable<T>> void sort(List<T> integerList) {
        for (int i = 1; i < integerList.size(); i++) {
            T current = integerList.get(i);
            int j = i - 1;
            while (j >= 0 && current.compareTo(integerList.get(j)) < 0) {
                integerList.set(j + 1, integerList.get(j));
                j--;
            }
            integerList.set(j + 1, current);
        }
    }

}
