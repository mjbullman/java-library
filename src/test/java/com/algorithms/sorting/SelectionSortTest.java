package com.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    @Test
    void testSortingIntegers() {
        Integer[] array = {5, 3, 8, 1, 2};
        Integer[] expected = {1, 2, 3, 5, 8};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingAlreadySortedArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingReverseOrder() {
        Integer[] array = {9, 7, 5, 3, 1};
        Integer[] expected = {1, 3, 5, 7, 9};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingSingleElementArray() {
        Integer[] array = {42};
        Integer[] expected = {42};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingEmptyArray() {
        Integer[] array = {};
        Integer[] expected = {};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingStringArray() {
        String[] array = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingStringsWithDifferentCases() {
        String[] array = {"Banana", "apple", "cherry", "Date"};
        String[] expected = {"Banana", "Date", "apple", "cherry"};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingDuplicateElements() {
        Integer[] array = {4, 2, 4, 1, 3, 2};
        Integer[] expected = {1, 2, 2, 3, 4, 4};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingArrayWithNegativeNumbers() {
        Integer[] array = {3, -1, 4, -5, 0};
        Integer[] expected = {-5, -1, 0, 3, 4};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    void testSortingNullArray() {
        assertDoesNotThrow(() -> SelectionSort.sort(null));
        assertNull(null);
    }

    @Test
    void testSortingBooleans() {
        Boolean[] array = {true, false, true, false, true};
        Boolean[] expected = {false, false, true, true, true};

        SelectionSort.sort(array);

        assertArrayEquals(expected, array);
    }
}
