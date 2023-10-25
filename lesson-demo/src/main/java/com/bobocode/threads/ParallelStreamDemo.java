package com.bobocode.threads;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

//ONLINE TRAINING 7 | TASK 2
//        👉  Compare sequential and parallel Stream computation [10 min]
//
//        Implement the following logic
//        Generate an array of random 1_000_000 positive integers
//        Using Stream API, filter numbers that are divisible by 3
//        Measure execution time for the following scenarios
//        Sequential stream
//        Parallel stream
//        Post  screenshots of your code in the Thread 👇
public class ParallelStreamDemo {
    public static void main(String[] args) {
        int[] ints = generateArray(1_000_000_00);
//        System.out.println(Arrays.toString(ints));

        processSequential(ints);

        System.out.println();
        System.out.println();
        System.out.println("---------------------");
        processParallel(ints);
        processSequential(ints);
//
    }

    private static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt();
        }
        return arr;
    }

    private static void processSequential(int[] arr) {
        System.out.println("Sequential");
        System.out.println("--------------");
        long start = System.currentTimeMillis();
        System.out.println("Start time: " + start);
        IntStream.of(arr)
                .filter(value -> value % 3 == 0)
                .toArray();
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void processParallel(int[] arr) {
        System.out.println("Parallel");
        System.out.println("--------------");
        long start = System.currentTimeMillis();
        System.out.println("Start time: " + start);
        IntStream.of(arr)
                .parallel()
                .filter(value -> value % 3 == 0)
                .toArray();
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
