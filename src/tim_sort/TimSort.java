package tim_sort;

import insertion_sort.InsertionSort;
import merge_sort.MergeSort;

import java.util.Arrays;

public record TimSort<T extends Comparable<T>>(T[] array) {
    private static final int MIN_RUN_SIZE = 2;

    public void sort() {
        for (int start = 0; start < array.length; start += MIN_RUN_SIZE) {
            int end = Math.min((start + MIN_RUN_SIZE - 1), (array.length - 1));
            new InsertionSort<>(array).sort(start, end);
        }

        for (int runSize = MIN_RUN_SIZE; runSize < array.length; runSize *= 2) {
            for (int left = 0; left < array.length; left += 2 * runSize) {
                int mid = left + runSize - 1;
                int right = Math.min(left + 2 * runSize - 1, array.length - 1);
                if (mid < right) new MergeSort<>(array).merge(left, mid, right);
            }
        }
    }
}
