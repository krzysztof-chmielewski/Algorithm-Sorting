package com.kchmielewski.algorithm.sorting.core;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
        }
        return data;
    }
}
