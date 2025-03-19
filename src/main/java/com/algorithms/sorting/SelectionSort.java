package com.algorithms.sorting;

/**
 * The {@code SelectionSort} class provides a generic implementation of the
 * selection sort algorithm for sorting an array of elements in ascending order.
 * <p>
 * Selection sort is an in-place, comparison-based sorting algorithm that repeatedly
 * selects the smallest element from the unsorted portion and swaps it with the first
 * unsorted element. It has a time complexity of O(n²) in all cases, making it inefficient
 * for large datasets but suitable for small datasets and educational purposes.
 * </p>
 *
 * @param <T> The type of elements in the array to be sorted. Must implement {@code Comparable<T>}.
 */
public class SelectionSort {
    /**
     * Sorts an array in ascending order using the Selection sort algorithm.
     *
     * @param <T>   The type of elements, must implement {@code Comparable}.
     * @param array The array to be sorted (modified in place).
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[smallestIndex]) < 0) {
                    smallestIndex = j;
                }
            }

            if (smallestIndex != i) {
                T temp = array[i];
                array[i] = array[smallestIndex];
                array[smallestIndex] = temp;
            }
        }
    }
}
