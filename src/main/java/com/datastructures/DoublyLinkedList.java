package com.datastructures;

/**
 * A generic implementation of a Doubly Linked List.
 *
 * @param <T> The type of elements stored in the list.
 */
public class DoublyLinkedList<T> {

    /**
     * Represents a node in the doubly linked list.
     *
     * @param <T> The type of data stored in the node.
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        /**
         * Constructs a new node with the given data.
         *
         * @param data The data to store in the node.
         */
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    /**
     * Initializes an empty doubly linked list.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Creates a new node with the given data.
     *
     * @param data The data to be stored in the node.
     * @return A new node containing the data.
     */
    private Node<T> newNode(T data) {
        return new Node<>(data);
    }

    /**
     * Checks if the provided index is within the valid range.
     *
     * @param index The index to check.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    private void checkIndexBounds(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param data The data to be added.
     */
    public void add(T data) {
        Node<T> newNode = this.newNode(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * Adds a new element at a specific index.
     *
     * @param index The index at which to insert the new element.
     * @param data  The data to be added.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void add(int index, T data) {
        checkIndexBounds(index);

        Node<T> newNode = this.newNode(data);
        Node<T> current = head;
        int currentIndex = 0;

        if (index == 0) {
            addFirst(data);
            return;
        }

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            addLast(data);
        } else {
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
    }

    /**
     * Adds a new element to the beginning of the list.
     *
     * @param data The data to be added.
     */
    public void addFirst(T data) {
        Node<T> newNode = this.newNode(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param data The data to be added.
     */
    public void addLast(T data) {
        add(data);
    }

    /**
     * Retrieves an element at a specific index.
     *
     * @param index The index of the element to retrieve.
     * @return The data at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public T get(int index) {
        checkIndexBounds(index);

        Node<T> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        return current != null ? current.data : null;
    }

    /**
     * Retrieves the first element in the list.
     *
     * @return The first element, or null if the list is empty.
     */
    public T getFirst() {
        return (head != null) ? head.data : null;
    }

    /**
     * Retrieves the last element in the list.
     *
     * @return The last element, or null if the list is empty.
     */
    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    /**
     * Removes an element at a specific index.
     *
     * @param index The index of the element to remove.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void remove(int index) {
        checkIndexBounds(index);

        if (index == 0) {
            removeFirst();
            return;
        }

        Node<T> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current == tail) {
                tail = current.prev;
            }
        }
    }

    /**
     * Removes the first element in the list.
     */
    public void removeFirst() {
        if (head == null) {
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
    }

    /**
     * Removes the last element in the list.
     */
    public void removeLast() {
        if (tail == null) {
            return;
        }

        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
    }

    /**
     * Converts the list into a string representation.
     *
     * @return A string representation of the list.
     */
    @Override
    public String toString() {
        if (head == null) {
            return "List is empty";
        }

        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.data);
            if (currentNode.next != null) {
                sb.append(" <-> ");
            }
            currentNode = currentNode.next;
        }

        sb.append(" <-> NULL");
        return sb.toString();
    }

    /**
     * Computes the size of the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        Node<T> current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    /**
     * Checks if the list contains a given element.
     *
     * @param data The data to search for.
     * @return True if the list contains the element, false otherwise.
     */
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Clears all elements from the list.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
    }
}
