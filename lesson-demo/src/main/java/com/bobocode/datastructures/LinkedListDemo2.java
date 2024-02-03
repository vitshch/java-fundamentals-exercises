package com.bobocode.datastructures;

public class LinkedListDemo2 {

    public static void main(String[] args) {
        var head = createLinkedList(1, 2, 3, 4, 5, 6, 7);
        printLinkedList(head);
        System.out.println();
        System.out.println("------------");
        printLinkedListReversed(head);
    }

    private static <T> Node<T> createLinkedList(T... elements) {
        var head = new Node<>(elements[0]);
        var current = head;
        for (int i = 1; i < elements.length; i++) {
            var newNode = new Node<>(elements[i]);
            current.next = newNode;
            current = newNode;
        }
        return head;
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    private static void printLinkedList(Node<?> head) {
        if (head.next == null) {
            System.out.print(head.value);
            return;
        }
        System.out.print(head.value + " -> ");
        printLinkedList(head.next);
    }

    // 5 -> 4 -> 3 -> 2 -> 1
    private static void printLinkedListReversed(Node<?> head) {
        print(head.next);
        System.out.print(head.value);
        System.out.println();
    }

    private static void print(Node<?> head) {
        if (head == null) {
            return;
        }
        print(head.next);
        System.out.print(head.value + " -> ");
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
