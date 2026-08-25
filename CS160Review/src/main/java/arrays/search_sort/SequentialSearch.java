package arrays.search_sort;

import java.util.Arrays;

/**
 * Example of sequential (linear) search.
 *
 * Sequential search checks each element from left to right until:
 * 1) the target value is found, or
 * 2) the array has been fully traversed.
 */
public class SequentialSearch {

    /**
     * Searches for target in numbers and returns its index.
     *
     * @param numbers array to search through
     * @param target value we are trying to find
     * @return index of target if found, otherwise -1
     */
    public static int sequentialSearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {42, 17, 8, 23, 99, 5};
        int target = 23;

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Searching for: " + target);

        int index = sequentialSearch(numbers, target);

        if (index >= 0) {
            System.out.println("Found " + target + " at index " + index + ".");
        } else {
            System.out.println(target + " was not found in the array.");
        }
    }
}
