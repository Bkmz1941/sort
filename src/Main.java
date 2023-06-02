import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] unsorted = new int[]{9, 5, 1, 7, 3, 2};
        System.out.println(Arrays.toString(quickSort(unsorted)));
    }

    private static int[] quickSort(int[] array) {
        if (array.length < 2) return array;

        // 1. pivot
        int pivotIndex = array.length / 2;
        int pivot = array[pivotIndex];

        // 2. less, greater
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

        // 3. recursion
        int[] L = quickSort(less.stream().mapToInt(Integer::intValue).toArray());
        int[] R = quickSort(greater.stream().mapToInt(Integer::intValue).toArray());

        int[] result = new int[L.length + R.length + 1];
        int i = 0;
        for (int l: L) {
            result[i++] = l;
        }
        result[i++] = pivot;
        for (int r: R) {
            result[i++] = r;
        }
        return result;
    }
}