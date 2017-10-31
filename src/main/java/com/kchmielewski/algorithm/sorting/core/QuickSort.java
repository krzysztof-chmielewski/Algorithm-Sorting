package com.kchmielewski.algorithm.sorting.core;

public class QuickSort implements SortingAlgorithm {
    @Override
    public SortingResult sort(int[] data) {
        return sort(data, 0, data.length - 1);
    }

    private SortingResult sort(int[] data, int lowerIndex, int higherIndex) {
        int first = data[lowerIndex];
        int second = data[(lowerIndex + higherIndex)/2];
        int third = data[higherIndex];
        int pivot = first > second && first < third ? first : (second > first && second < third ? second : third);

        int i = lowerIndex;
        int j = higherIndex;
        int swaps = 0;
        int iterations = 0;
        while (i <= j) {
            iterations++;
            while (data[i] < pivot) {
                iterations++;
                i++;
            }
            while (data[j] > pivot) {
                iterations++;
                j--;
            }
            if (i <= j) {
                swaps++;
                swap(data, i, j);
                i++;
                j--;
            }
        }

        SortingResult result = new SortingResult(data, swaps, iterations);
        if (lowerIndex < j) {
            SortingResult subResult = sort(data, lowerIndex, j);
            result = new SortingResult(data, swaps + subResult.swaps(), iterations + subResult.iterations());
        }
        if (higherIndex > i) {
            SortingResult subResult = sort(data, i, higherIndex);
            result = new SortingResult(data, swaps + subResult.swaps(), iterations + subResult.iterations());
        }

        return result;

    }

}
