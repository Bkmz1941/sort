package quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] unsorted = new int[]{9, 5, 1, 7, 3};
        quickSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {
        if (array.length < 2) return;

        int index = partition(array, startIndex, endIndex);
        if (startIndex < index - 1) {
            quickSort(array, startIndex, index - 1);
        }
        if (index < endIndex) {
            quickSort(array, index, endIndex);
        }
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[(startIndex + endIndex) / 2];

        while (startIndex <= endIndex) {
            while (array[startIndex] < pivot) {
                startIndex++;
            }
            while (array[endIndex] > pivot) {
                endIndex--;
            }
            if (startIndex < endIndex) {
                int temp = array[startIndex];
                array[startIndex] = array[endIndex];
                array[endIndex] = temp;
                startIndex++;
                endIndex--;
            }
        }

        return startIndex;
    }
}
