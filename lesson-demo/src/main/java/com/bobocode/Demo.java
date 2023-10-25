package com.bobocode;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 123;
        arr[1] = 134;

        System.out.println(Arrays.toString(arr));

        String[] strArr = new String[5];
        strArr[0] = "TEST";
        strArr[4] = "TEST4";

        System.out.println(Arrays.toString(strArr));

        Arrays.sort(arr);
    }
}
