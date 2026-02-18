# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

- **Build:** `mvn compile`
- **Run all tests:** `mvn test`
- **Run a single test class:** `mvn test -Dtest=BubbleSortTest`
- **Run a single test method:** `mvn test -Dtest=BubbleSortTest#testBubbleSortIntegerArray`
- **Lint (Checkstyle):** `mvn verify` (runs Sun checks; will fail the build on violations)
- **Clean build:** `mvn clean compile`

## Architecture

Java 11 Maven project containing algorithm and data structure implementations. No frameworks — just plain Java with JUnit 5 for tests.

### Package layout (`src/main/java/com/`)

- `algorithms/sorting/` — Sorting algorithms as static utility classes (e.g., `BubbleSort.sort(T[] array)`). All use generics with `Comparable<T>`.
- `algorithms/searching/` — Search algorithms (BinarySearch, LinearSearch), also static generic methods.
- `algorithms/graphs/` — Graph algorithms (Dijkstra, FloydWarshall, PrimMST) — mostly stubs.
- `datastructures/heaps/` — MinHeap and MaxHeap with configurable branching factor (2–10). MaxHeap does not extend MinHeap; they are independent implementations with the same structure but differ in `hasHigherPriority()`.
- `datastructures/linkedlists/` — Singly, doubly, and circular linked list implementations.
- `datastructures/trees/` — BinaryTree, BinarySearchTree, AVLTree, NaryTree.
- `datastructures/stacks/` — Stack implementations (array-backed and linked-list-backed).
- `datastructures/queues/` — Queue implementations (array, linked list, priority queue).

### Tests (`src/test/java/com/`)

Tests mirror the main source structure but not all implementations have tests. Test package paths don't always match source paths (e.g., `DoublyLinkedListTest` is in `com.datastructures` not `com.datastructures.linkedlists`).

## Code Conventions

- Sorting algorithms: static `sort()` method on a utility class, generic with `<T extends Comparable<T>>`.
- Data structures: generic classes with `<T>` or `<T extends Comparable<T>>` as needed.
- Heaps use an index map (`Map<T, Integer>`) for O(1) element lookup, enabling efficient `remove()` and `update()` operations.
- Javadoc is used extensively on public APIs (see MinHeap as the canonical example).
- Checkstyle enforces Sun coding conventions (`sun_checks.xml`).
