package merge_sort;

import java.util.Arrays;

public record MergeSort<T extends Comparable<T>>(T[] array) {
    public void merge(int start, int mid, int end) {
        T[] leftArray = (T[]) new Comparable[mid - start + 1];
        T[] rightArray = (T[]) new Comparable[end - mid];

        System.arraycopy(array, start, leftArray, 0, leftArray.length);
        System.arraycopy(array, mid + 1, rightArray, 0, rightArray.length);

        int i = start, l = 0, r = 0;
        while (l < leftArray.length && r < rightArray.length) {
            array[i++] = leftArray[l].compareTo(rightArray[r]) < 0 ? leftArray[l++] : rightArray[r++];
        }
        while (l < leftArray.length) {
            array[i++] = leftArray[l++];
        }
        while (r < rightArray.length) {
            array[i++] = rightArray[r++];
        }
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
