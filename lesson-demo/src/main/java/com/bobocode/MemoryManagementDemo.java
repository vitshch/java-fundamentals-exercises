package com.bobocode;

public class MemoryManagementDemo {


    public static void main(String[] args) {
        causeStackOverflow();
        polluteHeap();
    }

    //    Create a code snippet that puts too much data to the heap and causes an error
    public static void polluteHeap() {
        int[] array = new int[Integer.MAX_VALUE];
    }

    //    Create a code snippet that puts too much data on the stack and causes an error
    public static void causeStackOverflow() {
        causeStackOverflow();
    }

}
