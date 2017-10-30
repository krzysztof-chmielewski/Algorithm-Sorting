package com.kchmielewski.algorithm.sorting.core;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    swap(data, j, j - 1);
                }
            }
        }
        return data;
    }
}
