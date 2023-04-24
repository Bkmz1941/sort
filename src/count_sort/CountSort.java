package count_sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{6, 9, 6, 8, 14, 2, 14, 16, 12, 9, 11, 6, 15, 10, 16, 15};
        countSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void countSort(int[] array) {
        int MAX_VALUE = Arrays.stream(array).max().orElse(0);
        int[] counts = new int[MAX_VALUE + 1];

        for (int k: array) counts[k] += 1;

        int idx = 0;
        for (int i = 0; i < MAX_VALUE; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[idx] = i;
                idx++;
            }
        }
    }
}
