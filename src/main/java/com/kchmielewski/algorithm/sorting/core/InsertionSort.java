package com.kchmielewski.algorithm.sorting.core;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public SortingResult sort(int[] data) {
        int swaps = 0;
        int iterations = 0;
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j;

            for (j = i; j > 0; j--) {
                iterations++;
                if (data[j - 1] < tmp){
                    break;
                }
                swaps++;
                data[j] = data[j - 1];
            }
            swaps++;
            data[j] = tmp;
        }

        return new SortingResult(data, swaps, iterations);
    }
}
