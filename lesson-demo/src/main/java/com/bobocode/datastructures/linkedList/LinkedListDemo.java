package com.bobocode.datastructures.linkedList;

/**
 * ONLINE TRAINING 27 | TASK 0
 * 👉 Implement a simple Linked List in JS
 *
 * Create a simple version of Linked List implementing the following methods:
 * createLinkedList – accepts an array of elements, creates a linked list based on them and returns the head node
 * printLinkedList – accepts the head node and prints list in the following format 1 -> 2 -> 3 -> 4 -> 5
 * Post screenshots of your code in the Thread 👇
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        var head = createLinkedList(1, 2, 3, 4, 5);
        printLinkedList(head);

        Node<Integer> newNode = reverseLinkedList(head);
        printLinkedList(newNode);
    }

    private static <T> Node<T> createLinkedList(T... elements) {
        var head = new Node<>(elements[0]);
        var current = head;
        for (int i = 1; i <elements.length; i++) {
            var newNode = new Node<>(elements[i]);
            current.next = newNode;
            current = newNode;
        }
        return head;
    }

    private static void printLinkedList(Node<?> node) {
        if (node.next == null) {
            System.out.println(node.value);
            return;
        }
        System.out.print(node.value + "->");
        printLinkedList(node.next);
    }

    private static <T> Node<T> reverseLinkedList(Node<T> head) {
        var current = head;
        Node<T> prev = null;
        while (current != null) {
            var next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
