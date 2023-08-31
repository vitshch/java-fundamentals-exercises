package com.bobocode.min;

import java.util.List;

public class MinDemo {

    public static void main(String[] args) {
        System.out.println(findMin(List.of(6, 3, 4, 6, 79, 123, 3453, 7667, 5, 4, 67)));
    }

    public static int findMin(List<Integer> elements) {
        return elements.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow();
    }

}
