package com.algorithms.searching;

/**
 * Provides a static method to perform binary search on a sorted array.
 * <p>
 * Binary search is an efficient searching algorithm with a time complexity of O(log n).
 * It works by repeatedly dividing the search range in half until the target element is found
 * or the search range becomes empty.
 * </p>
 * <p>
 * This implementation requires the input array to be sorted in ascending order.
 * If the array is not sorted, the search result will be unreliable.
 * </p>
 *
 * @param <T> The type of elements in the array, which must implement
 *            the {@code Comparable} interface to allow comparisons.
 */
public class BinarySearch {
    /**
     * Searches for a specified key in a sorted array using the binary search algorithm.
     * <p>
     * If the key is found, the method returns its index in the array. If the key is not found,
     * the method returns -1.
     * </p>
     *
     * @param <T>   The type of elements in the array, which must implement {@code Comparable}.
     * @param array The sorted array in which to search for the key.
     * @param key   The value to search for.
     *
     * @return The index of the key if found, otherwise -1.
     */
    public static <T extends Comparable<T>> int search(T[] array, T key) {
       int low = 0;
       int high = array.length - 1;

       while (low <= high) {
           int mid = (low + high) / 2;

           if (array[mid].compareTo(key) == 0) {
               return mid;
           }
           if (array[mid].compareTo(key) < 0) {
               low = mid + 1;
           }
           if (array[mid].compareTo(key) > 0) {
               high = mid - 1;
           }
       }

        return -1;
    }
}
