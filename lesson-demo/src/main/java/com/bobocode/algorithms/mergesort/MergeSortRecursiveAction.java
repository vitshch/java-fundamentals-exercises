package com.bobocode.algorithms.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MergeSortRecursiveAction<T extends Comparable<? super T>> extends RecursiveAction {

    private final List<T> elements;

    public MergeSortRecursiveAction(List<T> elements) {
        this.elements = elements;
    }

    @Override
    protected void compute() {
        int size = elements.size();
        if (size == 1) {
            return;
        }
        int half = size / 2;

        var left = new ArrayList<>(elements.subList(0, half));
        var right = new ArrayList<>(elements.subList(half, size));

        var leftTask = new MergeSortRecursiveAction<>(left);
        var rightTask = new MergeSortRecursiveAction<>(right);
        leftTask.fork();
        leftTask.join();

        rightTask.fork();
        rightTask.join();

        merge(left, right);
    }

    private void merge(List<T> left, List<T> right) {
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                elements.set(i + j, left.get(i));
                i++;
            } else {
                elements.set(i + j, right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            elements.set(i + j, left.get(i));
            i++;
        }

        while (j < right.size()) {
            elements.set(i + j, right.get(j));
            j++;
        }
    }

}
