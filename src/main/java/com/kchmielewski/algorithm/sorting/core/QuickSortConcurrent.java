package com.kchmielewski.algorithm.sorting.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QuickSortConcurrent implements SortingAlgorithm {
    private final ExecutorService service = Executors.newCachedThreadPool();
    @Override
    public SortingResult sort(int[] data) throws ExecutionException, InterruptedException {
        return sort(data, 0, data.length - 1);
    }

    private SortingResult sort(int[] data, int lowerIndex, int higherIndex) throws ExecutionException, InterruptedException {
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
        Future<SortingResult> left = null;
        Future<SortingResult> right = null;

        if (lowerIndex < j && j - lowerIndex > 1000) {
            int finalJ = j;
            left = service.submit(() -> sort(data, lowerIndex, finalJ));
        } else if (lowerIndex < j){
            SortingResult subResult = sort(data, lowerIndex, j);
            result = new SortingResult(data, swaps + subResult.swaps(), iterations + subResult.iterations());
        }

        if (higherIndex > i && higherIndex - i > 1000) {
            int finalI = i;
            right = service.submit(() -> sort(data, finalI, higherIndex));
        } else if (higherIndex > i){
            SortingResult subResult = sort(data, lowerIndex, j);
            result = new SortingResult(data, swaps + subResult.swaps(), iterations + subResult.iterations());
        }

        if (left != null ) {
            result = new SortingResult(data, swaps + left.get().swaps(), iterations + left.get().iterations());
        }

        if (right != null) {
            result = new SortingResult(data, result.swaps() + right.get().swaps(), result.iterations() + right.get().iterations());
        }

        return result;
    }

    @Override
    public void close() {
        service.shutdown();
    }

}
