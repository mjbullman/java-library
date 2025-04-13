package com.datastructures.stacks;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * A generic Stack implementation using Java's LinkedList as the underlying data structure.
 * Supports typical stack operations: push, pop, peek, size, and isEmpty.
 *
 * @param <T> the type of elements held in this stack, must be comparable
 */
public class Stack<T extends Comparable<T>> {

    /**
     * Internal linked list used to store stack elements.
     */
    private final LinkedList<T> stack;

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        this.stack = new LinkedList<>();
    }

    /**
     * Returns the internal representation of the stack as a LinkedList.
     *
     * @return the internal LinkedList storing stack elements
     */
    public LinkedList<T> getStack() {
        return stack;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param value the element to be pushed onto the stack
     */
    public void push(T value) {
        this.stack.push(value);
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element removed from the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        return this.stack.pop();
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack, or {@code null} if the stack is empty
     */
    public T peek() {
        return this.stack.peek();
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return this.stack.size();
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}