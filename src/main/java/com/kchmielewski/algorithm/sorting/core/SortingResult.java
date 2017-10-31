package com.kchmielewski.algorithm.sorting.core;

import java.util.Arrays;

public class SortingResult {
    private final int[] data;
    private final int swaps;
    private final int iterations;

    public SortingResult(int[] data, int swaps, int iterations) {
        this.data = data;
        this.swaps = swaps;
        this.iterations = iterations;
    }

    public int[] data() {
        return data;
    }

    public int swaps() {
        return swaps;
    }

    public int iterations() {
        return iterations;
    }

    @Override
    public String toString() {
        return "SortingResult{" +
                "data=" + Arrays.toString(data) +
                ",\n swaps=" + swaps +
                ",\n iterations=" + iterations +
                '}';
    }
}
