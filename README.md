<div align="center">
    <img alt="Logo" src="https://cdn-icons-png.flaticon.com/512/226/226777.png" width="100" style="margin-top: 50px" />
</div>

<h1 align="center" style="margin-top: 15px">
    Java Library
</h1>

<h3 align="center" style="margin-top: -20px;">
    <a href="https://github.com/mjbullman/java-library">https://github.com/mjbullman/java-library</a>
</h3><br>

<div align="center" style="margin-top: 20px">

[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Last Commit](https://img.shields.io/github/last-commit/mjbullman/java-library?color=blue)](https://github.com/mjbullman/java-library/commits/main)
![Issues](https://img.shields.io/github/issues/mjbullman/java-library?color=blue)
![Pull Requests](https://img.shields.io/github/issues-pr/mjbullman/java-library?color=blue)

[![Java](https://img.shields.io/badge/Java-11-brightgreen.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-brightgreen.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5.10.x-brightgreen.svg)](https://junit.org/junit5/)

</div>

<h3 align="center">
    A comprehensive collection of <b>data structures</b> and <b>algorithms</b> implemented in <b>Java</b>,
    designed for learning, reference, and reuse.
</h3>

## Overview

This library provides clean, generic implementations of fundamental data structures and algorithms
commonly encountered in computer science. All implementations use Java generics where applicable,
with elements constrained by `Comparable<T>` for ordering operations.

## Algorithms

### Sorting

| Algorithm      | Time Complexity (Best) | Time Complexity (Avg) | Time Complexity (Worst) | Space Complexity |
|----------------|:----------------------:|:---------------------:|:-----------------------:|:----------------:|
| Bubble Sort    |          O(n)          |        O(n^2)         |         O(n^2)          |       O(1)       |
| Selection Sort |        O(n^2)          |        O(n^2)         |         O(n^2)          |       O(1)       |
| Insertion Sort |          O(n)          |        O(n^2)         |         O(n^2)          |       O(1)       |
| Counting Sort  |        O(n + k)        |       O(n + k)        |        O(n + k)         |      O(k)        |

### Searching

| Algorithm      | Time Complexity (Best) | Time Complexity (Avg) | Time Complexity (Worst) | Space Complexity |
|----------------|:----------------------:|:---------------------:|:-----------------------:|:----------------:|
| Linear Search  |          O(1)          |         O(n)          |          O(n)           |       O(1)       |
| Binary Search  |          O(1)          |       O(log n)        |        O(log n)         |       O(1)       |

## Data Structures

### Heaps

| Structure | Operations                                          | Time Complexity           |
|-----------|-----------------------------------------------------|---------------------------|
| MinHeap   | `add`, `top`, `peek`, `remove`, `update`, `contains` | O(log n) insert/delete, O(1) peek/contains |
| MaxHeap   | `add`, `top`, `peek`, `remove`, `update`, `contains` | O(log n) insert/delete, O(1) peek/contains |

Both heap implementations support a configurable **branching factor** (2-10) and use an internal
index map for O(1) element lookup, enabling efficient `remove()` and `update()` operations.

### Linked Lists

| Structure          | Description                                              |
|--------------------|----------------------------------------------------------|
| Singly Linked List | Linear list with forward-only traversal                  |
| Doubly Linked List | Linear list with bidirectional traversal                 |

### Trees

| Structure   | Description                                                   |
|-------------|---------------------------------------------------------------|
| Binary Tree | Generic binary tree with level-order (BFS) insertion          |

### Stacks

| Structure        | Description                                               |
|------------------|-----------------------------------------------------------|
| Stack            | LIFO stack backed by `LinkedList`                         |
| LinkedListStack  | Stack extending base `Stack` with linked list backend     |

### Queues

| Structure     | Description                                                  |
|---------------|--------------------------------------------------------------|
| Priority Queue | Priority-based queue using `ArrayList`                      |

### Utilities

| Class       | Description                                                       |
|-------------|-------------------------------------------------------------------|
| StringUtils | String helpers: `isEmpty`, `reverse`, `isPalindrome`              |

## Prerequisites

Before building the project, ensure you have the following installed:

- **Java** (JDK 11 or later)
- **Maven** (v3.x or later)

## Installation

### 1. Clone the Repository
```
git clone https://github.com/mjbullman/java-library.git
```

### 2. Navigate to the Project Directory
```
cd java-library
```

### 3. Build the Project
```
mvn clean compile
```

## Testing

Run all unit tests using **JUnit 5**:

```
mvn test
```

Run a specific test class:

```
mvn test -Dtest=BubbleSortTest
```

Run a specific test method:

```
mvn test -Dtest=BubbleSortTest#testBubbleSortIntegerArray
```

## Linting

Run **Checkstyle** with Sun coding conventions:

```
mvn verify
```

## Project Structure

```
src/
├── main/java/com/
│   ├── algorithms/
│   │   ├── graphs/          # Graph algorithms
│   │   ├── searching/       # Search algorithms
│   │   └── sorting/         # Sorting algorithms
│   ├── datastructures/
│   │   ├── heaps/           # Min and Max heap implementations
│   │   ├── linkedlists/     # Linked list variants
│   │   ├── queues/          # Queue implementations
│   │   ├── stacks/          # Stack implementations
│   │   └── trees/           # Tree implementations
│   ├── string/              # String utilities
│   └── utilities/           # General utilities
└── test/java/com/           # Unit tests (JUnit 5)
```

## Contributing

Feel free to fork this repository, raise issues, or submit pull requests. Contributions are
welcome and encouraged under the terms of the project's license.

Please ensure that your contributions follow the project's coding standards and guidelines.
After forking, clone your copy of the repository, create a branch for your work, and submit
a pull request for review.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
