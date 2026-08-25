package arrays.search_sort;

import java.util.Arrays;

/**
 * Example of selection sort.
 *
 * Selection sort repeatedly:
 * 1) finds the smallest value in the unsorted part of the array
 * 2) swaps it into the next sorted position
 */
public class SelectionSort {

    /**
     * Sorts the array in ascending order using selection sort.
     *
     * @param numbers array to sort (modified in place)
     */
    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int smallestIndex = i;

            // Find the smallest value in the unsorted section [i ... end].
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            // Swap only when we found a smaller value.
            if (smallestIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[smallestIndex];
                numbers[smallestIndex] = temp;
            }

            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(numbers));
        }
    }

    public static void main(String[] args) {
        int[] numbers = {29, 10, 14, 37, 13};

        System.out.println("Original array: " + Arrays.toString(numbers));
        selectionSort(numbers);
        System.out.println("Sorted array:   " + Arrays.toString(numbers));
    }
}
