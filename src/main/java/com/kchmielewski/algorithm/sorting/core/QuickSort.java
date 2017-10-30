package com.kchmielewski.algorithm.sorting.core;

public class QuickSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] data) {
        sort(data, 0, data.length - 1);

       return data;
    }

    private void sort(int[] data, int lowerIndex, int higherIndex) {
        int first = data[lowerIndex];
        int second = data[(lowerIndex + higherIndex)/2];
        int third = data[higherIndex];
        int pivot = first > second && first < third ? first : (second > first && second < third ? second : third);

        int i = lowerIndex;
        int j = higherIndex;
        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }
            while (data[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j) {
            sort(data, lowerIndex, j);
        }
        if (higherIndex > i) {
            sort(data, i, higherIndex);
        }
    }

}
