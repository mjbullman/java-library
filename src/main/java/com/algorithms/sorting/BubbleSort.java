package com.algorithms.sorting;

/**
 * The {@code BubbleSort} class provides a static method to perform the
 * bubble sort algorithm on an array of elements. The algorithm repeatedly
 * steps through the list, compares adjacent elements, and swaps them if
 * they are in the wrong order. The process is repeated until the array is
 * sorted.
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
     * Sorts an array of elements in ascending order using the bubble sort algorithm.
     * <p>
     * This method compares each pair of adjacent elements and swaps them if they are
     * in the wrong order. The process continues for each pass through the array,
     * reducing the size of the unsorted portion of the array with each iteration.
     * </p>
     *
     * @param <T> The type of elements in the array, which must implement
     *            the {@code Comparable} interface.
     * @param array The array of elements to be sorted. The array is modified
     *              in place, and no new array is created.
     *
     * @throws NullPointerException If the provided array is {@code null}.
     * @throws ClassCastException If the elements in the array are not {@code Comparable}.
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
