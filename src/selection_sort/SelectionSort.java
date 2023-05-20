package selection_sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] unsorted = new int[]{9, 5, 1, 7, 3};
        selectionSort(unsorted);
        for (int i : unsorted) {
             System.out.print(i);
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
