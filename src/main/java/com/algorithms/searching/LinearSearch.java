package com.algorithms.searching;

/**
 * Provides a static method for performing a linear search on an array.
 * <p>
 * This search algorithm iterates through the array, comparing each element
 * to the specified key until a match is found or the end of the array is reached.
 * </p>
 * <p>
 * Linear search has a time complexity of O(n), where n is the number of elements
 * in the array. This makes it inefficient for large datasets compared to other
 * search algorithms.
 * </p>
 *
 * @param <T> The type of elements in the array, which must implement the
 *            {@code Comparable} interface to support comparison.
 */
public class LinearSearch {
    /**
     * Searches for the specified key in the given array.
     *
     * @param <T>   The type of elements, must implement {@code Comparable}.
     * @param array The array to search (it will not be modified).
     * @param key   The value to search for in the array.
     * @return The index of the key if found; otherwise, returns -1.
     */
    public static <T extends Comparable<T>> int search (T[] array, T key) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(key) == 0) {
                return i;
            }
        }

        return -1;
    }
}
