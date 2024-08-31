package fundamentals.chapter1;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

        System.out.println(binarySearch(array, 11));
    }

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (target == array[middle]) {
                return middle;
            }
            else if (target > array[middle]) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
