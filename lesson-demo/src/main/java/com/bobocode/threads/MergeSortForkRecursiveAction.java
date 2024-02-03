package com.bobocode.threads;

import java.util.concurrent.RecursiveAction;

public class MergeSortForkRecursiveAction extends RecursiveAction {

    private int[] subArray;

    public MergeSortForkRecursiveAction(int[] subArray) {
        this.subArray = subArray;
    }

    @Override
    protected void compute() {

    }

}
