package com.kchmielewski.algorithm.sorting.core;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j;

            for (j = i; j > 0; j--) {
                if (data[j - 1] < tmp){
                    break;
                }
                data[j] = data[j - 1];
            }
            data[j] = tmp;
        }

        return data;
    }
}
