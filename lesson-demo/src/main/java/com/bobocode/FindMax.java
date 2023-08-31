package com.bobocode;

import java.util.List;

public class FindMax {

    public static void main(String[] args) {
        System.out.println(findMax(List.of(6, 3, 4, 6, 79, 123, 3453, 7667, 5, 4, 67)));
    }

    private static int findMax(List<Integer> elements) {
        return elements.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();
    }

}

//0. Learn everyday and make learning as a strong habbit
//1. Practice everyday. Small tasks, katas, etc. Try something new in small demo projects
//2. Use iterative approach to learn starting from basics. It'll be easier to learn advanced topics
//3. Learn topic by topic
//4. Use books, written by famous people in the sphere

