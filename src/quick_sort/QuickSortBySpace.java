package quick_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortBySpace {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{})));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(quickSort(new int[]{1})));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(quickSort(new int[]{1, 2})));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(quickSort(new int[]{2, 1})));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(quickSort(new int[]{9, 5, 1, 7, 3})));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(quickSort(new int[]{9, 5, 1, 7, 3, 2})));
        System.out.println("-----------------------------");
    }

    private static int [] quickSort(int[] array) {
        if (array.length < 2) return array;

        int pivotIndex = array.length / 2;
        int pivot = array[pivotIndex];

        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i == pivotIndex) continue;
            if (array[i] < pivot) {
                less.add(array[i]);
            } else {
                greater.add(array[i]);
            }
        }

        int[] L = quickSort(less.stream().mapToInt(Integer::intValue).toArray());
        int[] R = quickSort(greater.stream().mapToInt(Integer::intValue).toArray());

        List<Integer> result = new ArrayList<>();
        for (int j : L) {
            result.add(j);
        }
        result.add(pivot);
        for (int j : R) {
            result.add(j);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int i = startIndex - 1;

        for (int j = startIndex; j <= endIndex - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        int temp = array[i];
        array[i] = array[endIndex];
        array[endIndex] = temp;

        return i;
    }
}
