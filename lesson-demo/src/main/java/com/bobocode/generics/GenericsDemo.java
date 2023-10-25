package com.bobocode.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
//        numberList = integerList;
//        numberList.add(1.2);

        Number[] numbers = new Number[10];
        Integer[] integers = new Integer[10];

        numbers = integers;
    }

}
