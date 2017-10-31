package com.kchmielewski.algorithm.sorting.example;

import java.util.Random;

public class DataSets {
    private DataSets() {}

    public static int[] random(int size, int bound) {
       return random(size, bound, new Random());
    }

    public static int[] random(int size, int bound, Random random) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(bound);
        }

        return result;
    }

    public static int[] ascending(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i + 1;
        }

        return result;
    }

    public static int[] descending(int size) {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = size - i;
        }

        return result;
    }
}
