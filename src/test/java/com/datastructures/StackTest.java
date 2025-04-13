package com.datastructures;

import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import com.datastructures.stacks.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    public void testPopOnEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void testPeek() {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");

        assertEquals("world", stack.peek()); // should not remove element
        assertEquals("world", stack.pop());
    }

    @Test
    public void testIsEmpty() {
        Stack<Double> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(3.14);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        Stack<Character> stack = new Stack<>();
        assertEquals(0, stack.size());
        stack.push('A');
        stack.push('B');
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void testMultiplePushPop() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 100; i++) {
            stack.push(i);
        }

        for (int i = 100; i >= 1; i--) {
            assertEquals(i, stack.pop());
        }

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testNullPush() {
        Stack<String> stack = new Stack<>();
        stack.push(null);
        assertNull(stack.pop());
    }

    @Test
    public void testLargeNumberOfPushesAndPops() {
        Stack<Integer> stack = new Stack<>();
        int numElements = 1_000_000;

        // Push a large number of elements
        for (int i = 0; i < numElements; i++) {
            stack.push(i);
        }
        assertEquals(numElements, stack.size());

        // Pop all elements and verify order (LIFO)
        for (int i = numElements - 1; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testInterleavedPushPop() {
        Stack<String> stack = new Stack<>();
        int ops = 100_000;

        for (int i = 0; i < ops; i++) {
            stack.push("A" + i);
            if (i % 2 == 0) {
                assertEquals("A" + i, stack.pop());
            }
        }

        // Remaining elements should be half the ops
        assertEquals(ops / 2, stack.size());

        // Clean up remaining items
        while (!stack.isEmpty()) {
            stack.pop();
        }

        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStressPeekPerformance() {
        Stack<Integer> stack = new Stack<>();
        int size = 500_000;

        for (int i = 0; i < size; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 10_000; i++) {
            assertEquals(size - 1, stack.peek());
        }
    }
}
