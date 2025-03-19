package com.algorithms.sorting;

/**
 * Provides a static method to sort an array using the bubble sort algorithm.
 * This simple sorting algorithm repeatedly swaps adjacent elements if they
 * are in the wrong order until the array is sorted.
 * <p>
 * Bubble sort has a time complexity of O(n^2) in the worst and average case,
 * making it inefficient for large datasets. However, it is simple to implement
 * and can be useful for educational purposes or small datasets.
 * </p>
 *
 * @param <T> The type of elements in the array to be sorted, which must
 *            implement the {@code Comparable} interface to support comparison.
 */
public class BubbleSort {
    /**
     * Sorts an array in ascending order using the Bubble sort algorithm.
     *
     * @param <T>   The type of elements, must implement {@code Comparable}.
     * @param array The array to be sorted (modified in place).
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        boolean swapped;

        for (int i = 0; i <= array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break; // exit early if no swaps occurred.
            }
        }
    }
}
