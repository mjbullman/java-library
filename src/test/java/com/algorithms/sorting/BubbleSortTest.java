package com.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    public void testBubbleSortIntegerArray() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should sort integers correctly");
    }

    @Test
    public void testBubbleSortDoubleArray() {
        Double[] array = {5.5, 2.2, 9.9, 1.1, 5.5, 6.6};
        Double[] expected = {1.1, 2.2, 5.5, 5.5, 6.6, 9.9};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should sort doubles correctly");
    }

    @Test
    public void testBubbleSortStringArray() {
        String[] array = {"apple", "cherry", "date", "banana"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should sort strings correctly");
    }

    @Test
    public void testBubbleSortEmptyArray() {
        Integer[] array = {};
        Integer[] expected = {};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should handle empty arrays");
    }

    @Test
    public void testBubbleSortAlreadySortedArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should handle already sorted arrays");
    }

    @Test
    public void testBubbleSortSingleElementArray() {
        Integer[] array = {42};
        Integer[] expected = {42};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should handle arrays with a single element");
    }

    @Test
    public void testBubbleSortLargeArray() {
        Integer[] array = new Integer[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }

        Integer[] expected = new Integer[10000];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = i + 1;
        }

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should handle large arrays");
    }

    @Test
    public void testBubbleSortNegativeNumbers() {
        Integer[] array = {-5, -2, 9, -1, 5, 6};
        Integer[] expected = {-5, -2, -1, 5, 6, 9};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should handle negative numbers correctly");
    }

    @Test
    public void testBubbleSortDuplicates() {
        Integer[] array = {3, 2, 5, 1, 3, 5, 6, 6};
        Integer[] expected = {1, 2, 3, 3, 5, 5, 6, 6};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should handle duplicate values correctly");
    }

    @Test
    public void testBubbleSortMixedPositiveNegative() {
        Integer[] array = {5, -3, 7, -2, 0, -5, 9};
        Integer[] expected = {-5, -3, -2, 0, 5, 7, 9};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should handle mixed positive and negative numbers correctly");
    }

    @Test
    public void testBubbleSortFloatingPoint() {
        Double[] array = {3.14, 2.71, 1.62, 9.81, 5.55};
        Double[] expected = {1.62, 2.71, 3.14, 5.55, 9.81};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should handle floating point numbers correctly");
    }

    @Test
    public void testBubbleSortStringArrayReverseOrder() {
        String[] array = {"zebra", "apple", "banana", "date", "cherry"};
        String[] expected = {"apple", "banana", "cherry", "date", "zebra"};

        BubbleSort.sort(array);

        assertArrayEquals(expected, array, "Bubble sort should correctly sort string arrays in alphabetical order");
    }
}
