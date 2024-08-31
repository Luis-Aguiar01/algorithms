package fundamentals.chapter1.exercises;

/*
* Print values equals than target using binary search.
*/
public class Ex1_1_29 {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

        printValuesEqualsThanTarget(array, 20);
    }

    public static void printValuesEqualsThanTarget(int[] array, int target) {
        int valuesLowerThanTarget = getValuesLowerThanTarget(array, target);
        int valuesEqualsThanTarget = getValuesEqualsTheTarget(array, target);

        for (int i = 0; i < valuesEqualsThanTarget; i++) {
            System.out.println(array[valuesLowerThanTarget]);
            valuesLowerThanTarget++;
        }
    }

    public static int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

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

    public static int getValuesLowerThanTarget(int[] array, int target) {
        int count = 0;
        int targetIndex = binarySearch(array, target, 0, array.length - 1);

        if (targetIndex != -1) {
            int left = targetIndex - 1;

            while (left >= 0) {
                if (array[left] != target) {
                    count++;
                }
                left--;
            }
        }

        return count;
    }

    public static int getValuesEqualsTheTarget(int array[], int target) {
        int count = 0;
        int targetIndex = binarySearch(array, target, 0, array.length - 1);

        if (target != -1) {
            int right = targetIndex + 1;
            int left = targetIndex - 1;
            count++;

            while (right < array.length && array[right] == target) {
                count++;
                right++;
            }

            while (left >= 0 && array[left] == target) {
                count++;
                left--;
            }
        }

        return count;
    }
}
