package com.datastructures.heaps;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * A generic implementation of a MinHeap data structure that supports a configurable branching factor.
 * <p>
 * The MinHeap maintains the smallest element at the root, with the ability to efficiently perform
 * insertions, deletions, and updates. It is useful for algorithms such as Dijkstra's shortest path,
 * Huffman encoding, and for use as a priority queue.
 * </p>
 *
 * @param <T> The type of elements stored in the heap. Must implement {@code Comparable<T>} to
 *            allow ordering of elements.
 */
public class MinHeap<T extends Comparable<T>> {
    private final static int DEFAULT_BRANCH_FACTOR = 2;
    private final static int MAX_BRANCH_FACTOR = 10;

    private final List<T> heap;
    private final Map<T, Integer> heapIndexMap;
    private final int branchingFactor;

    /**
     * Constructs an empty MinHeap using the default binary structure (branching factor of 2).
     */
    public MinHeap() {
        this(DEFAULT_BRANCH_FACTOR);
    }

    /**
     * Constructs an empty MinHeap with the specified branching factor.
     * <p>
     * The branching factor determines how many children each node can have. Higher branching
     * factors can reduce tree depth but may increase the cost of reheapification.
     * </p>
     *
     * @param branchingFactor The number of children each node can have.
     * @throws IllegalArgumentException If the branching factor is out of allowed bounds.
     */
    public MinHeap(int branchingFactor) {
        heap = new ArrayList<>();
        heapIndexMap = new HashMap<>();

        validateBranchingFactor(branchingFactor);
        this.branchingFactor = branchingFactor;
    }

    /**
     * Constructs a MinHeap initialized with the provided list of elements and branching factor.
     * <p>
     * This constructor builds the heap in linear time using a bottom-up heapify process.
     * </p>
     *
     * @param elements The list of elements to initialize the heap with.
     * @param branchingFactor The number of children per node in the heap.
     * @throws NullPointerException If the input list is null.
     * @throws IllegalArgumentException If the branching factor is invalid.
     */
    public MinHeap(List<T> elements, int branchingFactor) throws IllegalArgumentException {
        validateBranchingFactor(branchingFactor);
        this.branchingFactor = branchingFactor;

        if (elements == null) {
            throw new NullPointerException("Null argument(s)");
        }

        int n = elements.size();
        this.heap = new ArrayList<>(elements);
        this.heapIndexMap = new HashMap<>();

        for (int i = getParentIndex(n - 1) + 1; i < n; i++) {
            this.heapIndexMap.put(this.heap.get(i), i);
        }

        for (int i = getParentIndex(n - 1); i >= 0; i--) {
            pushDown(i);
        }
    }

    /**
     * Retrieves and removes the smallest element from the heap (the root).
     * <p>
     * If the heap is empty, returns {@code null}. After removal, the heap is restructured to
     * maintain the heap property.
     * </p>
     *
     * @return The minimum element from the heap, or {@code null} if the heap is empty.
     */
    public T top() {
        if (heap.isEmpty()) {
            return null;
        }

        int n = heap.size();
        T top = heap.get(0);
        T lastElement = heap.remove(n - 1);

        if (n > 1) {
            heap.set(0, lastElement);
            heapIndexMap.put(lastElement, 0);
            this.pushDown(0);
        }

        heapIndexMap.remove(top);

        return top;
    }

    /**
     * Retrieves, but does not remove, the smallest element (root) of the heap.
     *
     * @return The current minimum element, or {@code null} if the heap is empty.
     */
    public T peek() {
        if (heap.isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    /**
     * Checks if a specific element exists in the heap.
     *
     * @param element The element to search for.
     * @return {@code true} if the element is present in the heap, {@code false} otherwise.
     */
    public boolean contains(T element) {
        return heapIndexMap.containsKey(element);
    }

    /**
     * Inserts a new element into the heap if it is not already present.
     * <p>
     * The element is inserted at the end of the heap and bubbled up to maintain heap ordering.
     * </p>
     *
     * @param element The element to add to the heap.
     * @return {@code true} if the element was successfully added, {@code false} if it already exists.
     */
    public boolean add(T element) {
        if (this.contains(element)) {
            return false;
        }

        heap.add(element);
        this.bubbleUp(heap.size() - 1);

        return true;
    }

    /**
     * Removes a specific element from the heap if it exists.
     * <p>
     * After removal, the heap is restructured to maintain the heap property.
     * </p>
     *
     * @param element The element to remove from the heap.
     * @return {@code true} if the element was found and removed, {@code false} otherwise.
     */
    public boolean remove(T element) {
        int n = this.size();
        int position = heapIndexMap.get(element);

        if (position == n - 1) {
            heap.remove(position);
            heapIndexMap.remove(element);
        }
        else {
            T lastElement = heap.get(n - 1);
            heap.set(position, lastElement);
            heap.remove(n - 1);
            heapIndexMap.remove(element);
            heapIndexMap.put(lastElement, position);

            if (hasHigherPriority(lastElement, element)) {
                bubbleUp(position);
            }
            else {
                pushDown(position);
            }
        }

        return true;
    }

    /**
     * Updates an existing element in the heap with a new value.
     * <p>
     * The position of the element is adjusted (bubble up or push down) depending on the new value
     * to preserve the heap property.
     * </p>
     *
     * @param oldValue The current value to be replaced.
     * @param newElement The new value to replace the old one.
     * @return {@code true} if the update was successful, {@code false} if the old value is not found or
     *         the new value already exists in the heap.
     */
    public boolean update(T oldValue, T newElement) {
        int position = heapIndexMap.get(oldValue);
        heap.set(position, newElement);
        heapIndexMap.remove(oldValue);
        heapIndexMap.put(newElement, position);

        if (hasHigherPriority(newElement, oldValue)) {
            bubbleUp(position);
        } else {
            pushDown(position);
        }

        return true;
    }

    /**
     * Bubbles the element at the specified index up the heap until the heap property is restored.
     *
     * @param index The index of the element to bubble up.
     */
    private void bubbleUp(int index) {
        int parentIndex;
        T element = heap.get(index);

        while (index > 0) {
            parentIndex = getParentIndex(index);
            T parent = heap.get(parentIndex);

            if (hasHigherPriority(element, parent)) {
                heap.set(index, parent);
                heapIndexMap.put(parent, index);
                index = parentIndex;
            }
            else {
                break;
            }
        }

        heap.set(index, element);
        heapIndexMap.put(element, index);
    }

    /**
     * Pushes the element at the specified index down the heap until the heap property is restored.
     *
     * @param index The index of the element to push down.
     */
    private void pushDown(int index) {
        int n = heap.size();
        int smallestChildrenIndex = getFirstChildIndex(index);
        T element = heap.get(index);

        while (smallestChildrenIndex < n) {
            int lastChildrenIndexGuard = Math.min(getFirstChildIndex(index) + branchingFactor, n);

            for (int childrenIndex = smallestChildrenIndex; childrenIndex < lastChildrenIndexGuard; childrenIndex++) {
                if (hasHigherPriority(heap.get(childrenIndex), heap.get(smallestChildrenIndex))) {
                    smallestChildrenIndex = childrenIndex;
                }
            }

            T child = heap.get(smallestChildrenIndex);

            if (hasHigherPriority(child, element)) {
                heap.set(index, child);
                heapIndexMap.put(child, index);
                index = smallestChildrenIndex;
                smallestChildrenIndex = getFirstChildIndex(index);
            }
            else {
                break;
            }
        }

        heap.set(index, element);
        heapIndexMap.put(element, index);
    }

    /**
     * Calculates the index of the first child of a given parent node in the heap.
     *
     * @param index The index of the parent node.
     * @return The index of its first child.
     */
    protected int getFirstChildIndex(int index) {
        return branchingFactor * index + 1;
    }

    /**
     * Calculates the index of the parent of a given node in the heap.
     *
     * @param index The index of the child node.
     * @return The index of its parent node.
     */
    protected int getParentIndex(int index) {
        return (index - 1) / branchingFactor;
    }

    /**
     * Compares two elements to determine if one has higher priority in the min-heap.
     * <p>
     * In a min-heap, an element has higher priority if it is less than another element.
     * </p>
     *
     * @param element The element to compare.
     * @param withRespectToElement The element to compare against.
     * @return {@code true} if the first element is smaller, {@code false} otherwise.
     */
    protected boolean hasHigherPriority(T element, T withRespectToElement) {
        return element.compareTo(withRespectToElement) < 0;
    }

    /**
     * Validates that the branching factor falls within the acceptable range.
     *
     * @param branchingFactor The branching factor to validate.
     * @throws IllegalArgumentException If the value is outside the allowed limits.
     */
    private void validateBranchingFactor(int branchingFactor) throws IllegalArgumentException {
        if (branchingFactor < DEFAULT_BRANCH_FACTOR || branchingFactor > MAX_BRANCH_FACTOR) {
            throw new IllegalArgumentException(
                    String.format("Branching factor needs to be an int between %d and %d",
                            DEFAULT_BRANCH_FACTOR, MAX_BRANCH_FACTOR)
            );
        }
    }

    /**
     * Retrieves the current size (number of elements) in the heap.
     *
     * @return the size of the heap.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Clears all elements from the heap.
     */
    public void clear() {
        heap.clear();
        heapIndexMap.clear();
    }

    /**
     * Returns a string representation of the heap.
     *
     * @return a string representation of the heap.
     */
    @Override
    public String toString() {
        return heap.toString();
    }

    /**
     * Prints a pretty-printed tree structure of the heap for visualization.
     */
    public void printPrettyTree() {
        if (heap.isEmpty()) {
            return;
        }

        int size = heap.size();
        int level = 0;
        int index = 0;
        int maxLevel = (int) (Math.log(size * (branchingFactor - 1) + 1) / Math.log(branchingFactor));

        while (index < size) {
            int levelSize = (int) Math.pow(branchingFactor, level);
            int nodesInLevel = Math.min(levelSize, size - index);

            // calculate padding.
            int totalWidth = (int) Math.pow(branchingFactor, maxLevel) * 4;
            int nodeSpacing = totalWidth / (nodesInLevel + 1);

            // print nodes in the current level
            for (int i = 0; i < nodesInLevel; i++) {
                System.out.printf("%" + nodeSpacing + "s", heap.get(index++));
            }

            System.out.println("\n");
            level++;
        }
    }
}
