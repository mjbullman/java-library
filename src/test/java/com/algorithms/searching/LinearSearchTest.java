package com.algorithms.searching;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearSearchTest {

    @Test
    public void testSearchIntegerArray() {
        Integer[] array = {10, 20, 30, 40, 50};
        assertEquals(2, LinearSearch.search(array, 30));
        assertEquals(-1, LinearSearch.search(array, 60));
    }

    @Test
    public void testSearchStringArray() {
        String[] array = {"apple", "banana", "cherry", "date"};
        assertEquals(1, LinearSearch.search(array, "banana"));
        assertEquals(-1, LinearSearch.search(array, "grape"));
    }

    @Test
    public void testSearchCharacterArray() {
        Character[] array = {'a', 'b', 'c', 'd', 'e'};
        assertEquals(4, LinearSearch.search(array, 'e'));
        assertEquals(-1, LinearSearch.search(array, 'z'));
    }

    @Test
    public void testSearchWithEmptyArray() {
        Integer[] emptyArray = {};
        assertEquals(-1, LinearSearch.search(emptyArray, 10));
    }

    @Test
    public void testSearchSingleElementArray() {
        Integer[] array = {100};
        assertEquals(0, LinearSearch.search(array, 100));
        assertEquals(-1, LinearSearch.search(array, 200));
    }

    @Test
    public void testSearchFirstElement() {
        Integer[] array = {10, 20, 30, 40, 50};
        assertEquals(0, LinearSearch.search(array, 10));
    }

    @Test
    public void testSearchLastElement() {
        Integer[] array = {10, 20, 30, 40, 50};
        assertEquals(4, LinearSearch.search(array, 50));
    }

    @Test
    public void testSearchNegativeNumbers() {
        Integer[] array = {-10, -5, 0, 5, 10};
        assertEquals(1, LinearSearch.search(array, -5));
        assertEquals(-1, LinearSearch.search(array, -15));
    }

    @Test
    public void testSearchLargeArray() {
        Integer[] array = new Integer[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        // assertEquals(999999, LinearSearch.search(array, 999999));
        assertEquals(-1, LinearSearch.search(array, 1000001));
    }
}
