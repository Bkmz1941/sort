package binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        int idx = binarySearch(array1, 7);
        System.out.println(idx);
    }

    public static int binarySearch(int[] array, int target) {
        int start = 0, end = array.length - 1;
        while (start != end) {
            int mid = (end + start) / 2;
            int diff = target - array[mid];

            if (diff < 0) {
                end = mid - 1;
            } else if (diff > 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -(start + 1);
    }
}
