package com.bobocode.threads;

import com.bobocode.algorithms.MergeSortDemo;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortRecursiveAction extends RecursiveAction {

    private int[] arr;

    public MergeSortRecursiveAction(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected void compute() {
        if (arr.length < 2) {
            return;
        }
        var size = arr.length / 2;

        var left = Arrays.copyOfRange(arr, 0, size);
        var right = Arrays.copyOfRange(arr, size, arr.length);

        var leftTask = new MergeSortRecursiveAction(left);
        var rightTask = new MergeSortRecursiveAction(right);

        leftTask.fork();
        rightTask.compute();
        rightTask.fork();
        ParallelMergeSortDemo.merge(arr, left, right);
    }

}
