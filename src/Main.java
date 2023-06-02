import tim_sort.TimSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] unsorted = new Integer[]{9, 5, 1, 7, 3, 2, 0, 4, 8, 3, 0};
        TimSort<Integer> sort = new TimSort<>(unsorted);
        sort.sort();
        System.out.println(Arrays.toString(unsorted));
    }
}