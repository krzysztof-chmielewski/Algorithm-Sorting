package com.kchmielewski.algorithm.sorting.core;

public interface SortingAlgorithm {

    SortingResult sort(int[] data);

    default void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
