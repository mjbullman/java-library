package com.datastructures.heaps;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {

    private MaxHeap<Integer> heap;

    @BeforeEach
    public void setup() {
        heap = new MaxHeap<>(3);
    }

    @Test
    public void testAddAndPeek() {
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(1);

        heap.printPrettyTree();

        System.out.println(heap.toString());
        assertEquals(20, heap.peek());
    }

    @Test
    public void testTopRemovesMax() {
        heap.add(10);
        heap.add(3);
        heap.add(7);

        assertEquals(10, heap.top());
        assertEquals(7, heap.peek());
        assertEquals(2, heap.size());
    }

    @Test
    public void testContains() {
        heap.add(42);
        assertTrue(heap.contains(42));
        assertFalse(heap.contains(99));
    }

    @Test
    public void testRemoveElement() {
        heap.add(4);
        heap.add(2);
        heap.add(5);

        assertTrue(heap.remove(5));
        assertFalse(heap.contains(5));
        assertEquals(2, heap.size());
    }

    @Test
    public void testUpdateIncreasesPriority() {
        heap.add(8);
        heap.add(10);
        heap.add(20);

        assertTrue(heap.update(8, 25));
        assertEquals(25, heap.peek());
    }

    @Test
    public void testUpdateDecreasesPriority() {
        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertTrue(heap.update(3, 0));
        assertEquals(2, heap.peek());
    }

    @Test
    public void testAddDuplicateFails() {
        heap.add(100);
        assertFalse(heap.add(100));
    }

    @Test
    public void testClearHeap() {
        heap.add(1);
        heap.add(2);
        heap.clear();

        assertEquals(0, heap.size());
        assertNull(heap.top());
    }

    @Test
    public void testHeapifyConstructor() {
        List<Integer> input = Arrays.asList(9, 3, 7, 1, 2);
        MaxHeap<Integer> heapFromList = new MaxHeap<>(input, 2);

        assertEquals(9, heapFromList.peek());
        assertEquals(5, heapFromList.size());
    }

    @Test
    public void testEmptyHeapTopReturnsNull() {
        assertNull(heap.top());
    }

    @Test
    public void testRemoveLastElement() {
        heap.add(88);
        assertTrue(heap.remove(88));
        assertEquals(0, heap.size());
        assertNull(heap.peek());
    }

    @Test
    public void testBranchingFactorValidation() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new MaxHeap<>(Arrays.asList(1, 2, 3), 100)
        );
        assertTrue(thrown.getMessage().contains("Branching factor needs to be an int between"));
    }

    @Test
    public void testHeapAddDuplicates_Large() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        int count = 10000;

        for (int i = 0; i < count; i++) {
            assertTrue(heap.add(i));
            assertFalse(heap.add(i));
        }

        assertEquals(count, heap.size());
    }

    @Test
    public void testHeapUpdate_Large() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        int count = 5000;

        for (int i = 0; i < count; i++) {
            heap.add(i);
        }

        boolean updated = heap.update(0, 100000);
        assertTrue(updated);

        assertEquals(100000, heap.peek());
    }

    @Test
    public void testRandomInsertAndRemove() {
        MaxHeap<Integer> heap = new MaxHeap<>();
        TreeSet<Integer> reference = new TreeSet<>();
        Random rand = new Random(101);

        int operations = 5000;
        for (int i = 0; i < operations; i++) {
            int op = rand.nextInt(3);

            switch (op) {
                case 0:
                    int val = rand.nextInt(10000);
                    heap.add(val);
                    reference.add(val);
                    break;
                case 1:
                    Integer expected = reference.isEmpty() ? null : reference.last();
                    assertEquals(expected, heap.peek());
                    break;
                case 2:
                    if (!reference.isEmpty()) {
                        Integer max = reference.pollLast();
                        assertEquals(max, heap.top());
                    } else {
                        assertNull(heap.top());
                    }
                    break;
            }
        }
    }
}
