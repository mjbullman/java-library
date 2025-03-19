package com.algorithms.searching;

import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    public void testSearchIntegerArray() {
        Integer[] array = {1, 3, 5, 7, 9};

        assertEquals(2, BinarySearch.search(array, 5));
        assertEquals(-1, BinarySearch.search(array, 6));
    }

    @Test
    public void testSearchDoubleArray() {
        Double[] array = {1.1, 2.2, 3.3, 4.4, 5.5};

        assertEquals(3, BinarySearch.search(array, 4.4));
        assertEquals(-1, BinarySearch.search(array, 6.6));
    }

    @Test
    public void testSearchStringArray() {
        String[] array = {"apple", "banana", "cherry", "date", "fig"};

        assertEquals(1, BinarySearch.search(array, "banana"));
        assertEquals(-1, BinarySearch.search(array, "grape"));
    }

    @Test
    public void testSearchCharacterArray() {
        Character[] array = {'a', 'c', 'e', 'g', 'i'};

        assertEquals(2, BinarySearch.search(array, 'e'));
        assertEquals(-1, BinarySearch.search(array, 'b'));
    }

    @Test
    public void testEmptyArray() {
        Integer[] emptyArray = {};

        assertEquals(-1, BinarySearch.search(emptyArray, 5));
    }

    @Test
    public void testSingleElementArray() {
        Integer[] array = {10};

        assertEquals(0, BinarySearch.search(array, 10));
        assertEquals(-1, BinarySearch.search(array, 5));
    }

    @Test
    public void testFirstAndLastElement() {
        Integer[] array = {10, 20, 30, 40, 50};

        assertEquals(0, BinarySearch.search(array, 10));
        assertEquals(4, BinarySearch.search(array, 50));
    }

    @Test
    public void testLargeDataset() {
        Integer[] array = IntStream.rangeClosed(1, 1000000).boxed().toArray(Integer[]::new);

        assertEquals(499999, BinarySearch.search(array, 500000));
        assertEquals(-1, BinarySearch.search(array, 1000001));
    }

    @Test
    public void testSearchWithLargeDoubleArray() {
        Double[] array = DoubleStream.iterate(1.0, n -> n + 1.0)
                .limit(1000000).boxed().toArray(Double[]::new);

        assertEquals(499999, BinarySearch.search(array, 500000.0));
        assertEquals(-1, BinarySearch.search(array, 1000001.0));
    }
}
