package com.kchmielewski.algorithm.sorting.example;

import com.kchmielewski.algorithm.sorting.core.*;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<SortingAlgorithm> algorithms = Arrays.asList(new BubbleSort(), new InsertionSort(), new QuickSort());

        int n = 1000;
        int[][] data = new int[n][];
        for (int i = 0; i < n; i++) {
            data[i] = DataSets.random(5000, 5000, new Random());
        }

        for (SortingAlgorithm sortingAlgorithm : algorithms) {
            long time = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                int[] array = Arrays.copyOf(data[i], data.length);
                sortingAlgorithm.sort(array);
            }
            System.out.println("Total time for " + sortingAlgorithm + ": " + (System.currentTimeMillis() - time));
        }

    }
}
