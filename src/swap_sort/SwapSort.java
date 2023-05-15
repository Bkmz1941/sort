package swap_sort;

import java.util.Arrays;

public class SwapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{15, 21, 20, 2, 15, 24, 5, 19};
        swapSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void swapSort(int[] nums) {
        int leftBoard = 0;
        int rightBoard = nums.length - 1;

        while (leftBoard < rightBoard) {
            int minIndex = leftBoard;
            int maxIndex = rightBoard;

            for (int i = leftBoard; i <= rightBoard; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;

                }
            }

            swap(leftBoard, minIndex, nums);
            leftBoard++;
            if (nums[rightBoard] < nums[maxIndex]) {
                swap(rightBoard, maxIndex, nums);
                rightBoard--;
            }


            leftBoard++;

        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
