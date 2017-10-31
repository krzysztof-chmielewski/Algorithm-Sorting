package com.kchmielewski.algorithm.sorting.core;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public SortingResult sort(int[] data) {
        int swaps = 0;
        int iterations = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                iterations++;
                if (data[j] > data[j + 1]) {
                    swaps++;
                    swap(data, j, j+ 1);
                }
            }
        }

        return new SortingResult(data, swaps, iterations);
    }
}
