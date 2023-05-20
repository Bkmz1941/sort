package insertion_sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] unsorted = new int[]{9, 5, 1, 7, 3};
        insertionSort(unsorted);
        for (int i : unsorted) {
            System.out.print(i);
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }
    }
}
