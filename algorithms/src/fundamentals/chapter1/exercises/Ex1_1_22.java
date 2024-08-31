package fundamentals.chapter1.exercises;

public class Ex1_1_22 {
    private static int profundidade = 1;

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

        System.out.println("Profundidade\tLow\tHigh");
        int result = binarySearch(array, 3, 0, array.length - 1);

        System.out.println("\nFind index: " + result);
    }

    public static int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        System.out.println("\t" + profundidade++ + "\t\t\t" + low + "\t" + high);

        if (target == array[middle]) {
            return middle;
        } else if (target > array[middle]) {
            low = middle + 1;
            return binarySearch(array, target, low, high);
        } else {
            high = middle - 1;
            return binarySearch(array, target, low, high);
        }
    }
}
