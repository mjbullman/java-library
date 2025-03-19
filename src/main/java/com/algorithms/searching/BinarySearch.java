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
     * @param <T>         The type of elements in the array, which must implement {@code Comparable}.
     * @param sortedArray The sorted array in which to search for the key.
     * @param key         The value to search for.
     *
     * @return The index of the key if found, otherwise -1.
     */
    public static <T extends Comparable<T>> int search(T[] sortedArray, T key) {
       int low = 0;
       int high = sortedArray.length - 1;

       while (low <= high) {
           int mid = (low + high) / 2;

           if (sortedArray[mid].compareTo(key) == 0) {
               return mid;
           }
           if (sortedArray[mid].compareTo(key) < 0) {
               low = mid + 1;
           }
           if (sortedArray[mid].compareTo(key) > 0) {
               high = mid - 1;
           }
       }

        return -1;
    }

    /**
     * Performs a recursive binary search on a sorted array to find the index of the specified key.
     *
     * <p>
     * This method divides the search range in half each time, making it efficient for searching in
     * large datasets with a time complexity of O(log n). The array must be sorted for binary search
     * to function correctly.
     * </p>
     *
     * <p>
     * If the key is found in the array, the index of the key is returned. If the key is not present,
     * the method returns -1.
     * </p>
     *
     * @param <T> The type of the elements in the array, which must implement the {@code Comparable} interface
     *            to support comparison.
     * @param sortedArray The array to search in, which must be sorted in ascending order.
     * @param key The value to search for in the array.
     * @param low The starting index of the search range (inclusive).
     * @param high The ending index of the search range (inclusive).
     * @return The index of the key if found, otherwise -1.
     */
    public static <T extends Comparable<T>> int searchRecursive(T[] sortedArray, T key, Integer low, Integer high) {
        int mid = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (sortedArray[mid].compareTo(key) == 0) {
            return mid;
        }
        else if (sortedArray[mid].compareTo(key) < 0) {
            return searchRecursive(sortedArray, key, low, mid - 1);
        }
        else if (sortedArray[mid].compareTo(key) > 0) {
            return searchRecursive(sortedArray, key, mid + 1, high);
        }

        return -1;
    }
}
