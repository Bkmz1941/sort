package selection_sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] unsorted = new int[]{9, 5, 1, 7, 3};
        selectionSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, array);
        }
    }

    private static void swap(int x, int y, int[] array) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
