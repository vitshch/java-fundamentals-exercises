package com.bobocode.algorithms.mergesort2;

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
        var size = elements.size();
        if (size <= 1) {
            return;
        }

        var half = size / 2;

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
        int l = 0, r = 0;
        int leftSize = left.size();
        int rightSize = right.size();

        while (l < leftSize && r < rightSize) {
            if (left.get(l).compareTo(right.get(r)) < 0) {
                elements.set(l + r, left.get(l));
                l++;
            } else {
                elements.set(l + r, right.get(r));
                r++;
            }
        }

        while (l < left.size()) {
            elements.set(l + r, left.get(l));
            l++;
        }

        while (r < right.size()) {
            elements.set(l + r, right.get(r));
            r++;
        }

    }

}
