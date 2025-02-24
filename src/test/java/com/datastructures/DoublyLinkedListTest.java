package com.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> intList;
    private DoublyLinkedList<String> stringList;
    private DoublyLinkedList<Double> doubleList;
    private DoublyLinkedList<Float> floatList;
    private DoublyLinkedList<Long> longList;
    private DoublyLinkedList<Boolean> booleanList;
    private DoublyLinkedList<Character> charList;

    @BeforeEach
    void setup() {
        intList = new DoublyLinkedList<>();
        stringList = new DoublyLinkedList<>();
        doubleList = new DoublyLinkedList<>();
        floatList = new DoublyLinkedList<>();
        longList = new DoublyLinkedList<>();
        booleanList = new DoublyLinkedList<>();
        charList = new DoublyLinkedList<>();
    }

    @Test
    void testIntegerList() {
        intList.add(1);
        intList.add(2);
        intList.add(3);

        assertEquals(3, intList.size());
        assertEquals(1, intList.getFirst());
        assertEquals(3, intList.getLast());
    }

    @Test
    void testStringList() {
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        assertEquals(3, stringList.size());
        assertEquals("A", stringList.getFirst());
        assertEquals("C", stringList.getLast());
        assertTrue(stringList.contains("B"));
    }

    @Test
    void testDoubleList() {
        doubleList.add(10.5);
        doubleList.add(20.7);
        doubleList.add(30.9);

        assertEquals(3, doubleList.size());
        assertEquals(10.5, doubleList.getFirst());
        assertEquals(30.9, doubleList.getLast());
    }

    @Test
    void testFloatList() {
        floatList.add(1.1f);
        floatList.add(2.2f);
        floatList.add(3.3f);

        assertEquals(3, floatList.size());
        assertEquals(1.1f, floatList.getFirst());
        assertEquals(3.3f, floatList.getLast());
    }

    @Test
    void testLongList() {
        longList.add(10000000000L);
        longList.add(20000000000L);
        longList.add(30000000000L);

        assertEquals(3, longList.size());
        assertEquals(10000000000L, longList.getFirst());
        assertEquals(30000000000L, longList.getLast());
    }

    @Test
    void testBooleanList() {
        booleanList.add(true);
        booleanList.add(false);
        booleanList.add(1, false);
        booleanList.add(2, true);
        booleanList.add(3, false);

        assertEquals(5, booleanList.size());
        assertEquals(true, booleanList.getFirst());
        assertEquals(false, booleanList.getLast());
        assertEquals(false, booleanList.get(3));
    }

    @Test
    void testCharacterList() {
        charList.add('X');
        charList.add('Y');
        charList.add('Z');

        assertEquals(3, charList.size());
        assertEquals('X', charList.getFirst());
        assertEquals('Z', charList.getLast());
    }

    @Test
    void testAddFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(100);
        list.addFirst(200);
        list.addFirst(300);

        assertEquals(3, list.size());
        assertEquals(300, list.getFirst());
        assertEquals(100, list.getLast());
    }

    @Test
    void testAddLast() {
        stringList.addLast("Alice");
        stringList.addLast("Bob");
        stringList.addLast("Charlie");

        assertEquals(3, stringList.size());
        assertEquals("Alice", stringList.getFirst());
        assertEquals("Charlie", stringList.getLast());
    }

    @Test
    void testRemoveFirst() {
        stringList.add("Alice");
        stringList.add("Bob");
        stringList.add("Charlie");
        stringList.removeFirst();

        assertEquals(2, stringList.size());
        assertEquals("Bob", stringList.getFirst());
    }

    @Test
    void testRemoveLast() {
        stringList.add("Alice");
        stringList.add("Bob");
        stringList.add("Charlie");
        stringList.removeLast();

        assertEquals(2, stringList.size());
        assertEquals("Bob", stringList.getLast());
    }

    @Test
    void testRemoveAtIndex() {
        stringList.add("Alice");
        stringList.add("Bob");
        stringList.add("Charlie");
        stringList.add("David");

        stringList.remove(2);

        assertEquals(3, stringList.size());
        assertEquals("David", stringList.get(2));
    }

    @Test
    void testClear() {
        stringList.add("Alice");
        stringList.add("Bob");
        stringList.add("Charlie");
        stringList.clear();

        assertEquals(0, stringList.size());
        assertTrue(stringList.isEmpty());
    }

    @Test
    void testContains() {
        stringList.add("Alice");
        stringList.add("Bob");
        stringList.add("Charlie");

        assertTrue(stringList.contains("Bob"));
        assertFalse(stringList.contains("David"));
    }
}
