package com.kchmielewski.algorithm.sorting.core;

import java.util.concurrent.ExecutionException;

public interface SortingAlgorithm {

    SortingResult sort(int[] data) throws ExecutionException, InterruptedException;

    default void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    default void close() {
    }

}
