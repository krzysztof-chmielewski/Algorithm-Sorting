package com.kchmielewski.algorithm.sorting.example;

import com.kchmielewski.algorithm.sorting.core.BubbleSort;
import com.kchmielewski.algorithm.sorting.core.InsertionSort;
import com.kchmielewski.algorithm.sorting.core.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] data = DataSets.random(20, 20, new Random(42));
        System.out.println(Arrays.toString(data));
        new BubbleSort().sort(data);
        System.out.println(Arrays.toString(data));
        System.out.println("-----------------------");

        data = DataSets.random(20, 20, new Random(42));
        System.out.println(Arrays.toString(data));
        new InsertionSort().sort(data);
        System.out.println(Arrays.toString(data));
        System.out.println("-----------------------");

        data = DataSets.random(20, 20, new Random(42));
        System.out.println(Arrays.toString(data));
        new QuickSort().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
