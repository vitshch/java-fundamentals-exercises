package com.bobocode;

public class LinkedListDemo2 {
    public static void main(String[] args) {
        var intListHead = createLinkedList(1, 2, 3, 4, 5);
        printLinkedList(intListHead);
        System.out.println();
        printLinkedListRecursively(intListHead);
    }

    /**
     * Creates a linked list based on the provided elements and returns a list head.
     *
     * @param elements
     * @param <T>
     * @return created list head
     */
    public static <T> Node<T> createLinkedList(T... elements) {
        Node<T> head = new Node<>(elements[0]);
        Node<T> current = head;
        for (int i = 1; i < elements.length; i++) {
            var newNode = new Node<>(elements[i]);
            current.next = newNode;
            current = newNode;
        }
        return head;
    }

    /**
     * Prints a provided linked list in the following format:
     * 1 -> 2 -> 3 -> 4 -> 5
     *
     * @param head a list head
     */
    public static void printLinkedList(Node<?> head) {
        var current = head;
        while (current.next != null) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }
        System.out.print(current.element);
    }

    /**
     * Prints a provided linked list recursively in the following format:
     * 1 -> 2 -> 3 -> 4 -> 5
     * 
     * @param head a list head
     */
    public static void printLinkedListRecursively(Node<?> head) {
        if (head.next != null) {
            System.out.print(head.element + " -> ");
            printLinkedListRecursively(head.next);
        } else {
            System.out.print(head.element);
        }
    }

    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }


}