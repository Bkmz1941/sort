package merge_sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] unsorted = new int[]{9, 5, 1, 7, 3};
        mergeSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    public static void mergeSort(int[] array) {
        if (array.length < 2) return;

        int middle = array.length / 2;

        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        int l = 0, r = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < middle) left[l++] = array[i];
            else right[r++] = array[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] array) {
        int i = 0, l = 0, r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                array[i] = left[l];
                l++;
                i++;
            } else {
                array[i] = right[r];
                r++;
                i++;
            }
        }
        while (l < left.length) {
            array[i] = left[l];
            l++;
            i++;
        }
        while (r < right.length) {
            array[i] = right[r];
            r++;
            i++;
        }
    }


}
