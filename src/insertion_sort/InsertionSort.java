package insertion_sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public record InsertionSort<T extends Comparable<T>>(T[] array) {
    public void sort() {
        for (int i = 1; i < this.array.length; i++) {
            T temp = this.array[i];
            int j = i - 1;
            while (j >= 0 && this.array[j].compareTo(temp) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            this.array[j + 1] = temp;
        }
    }
    public void sort(int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            T temp = this.array[i];
            int j = i - 1;
            while (j >= start && this.array[j].compareTo(temp) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            this.array[j + 1] = temp;
        }

//        while (start <= end) {
//            System.out.print(array[start] + ", ");
//            start++;
//        }
//        System.out.println();
    }
}
