package com.bobocode;

public class LinkedListDemo {

    public static void main(String[] args) {
        var head = createLinkedList(1, 2, 3, 4, 5);
        printLinkedList(head);
        System.out.println("-----------------------");
        printLinkedListReversed(head);
        System.out.println("-----------------------");
        var reversed = reverseLinkedList(head);
        printLinkedList(reversed);
    }


    private static <T> Node<T> createLinkedList(T... values) {
        Node<T> head = new Node<>(values[0]);
        Node<T> current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node<>(values[i]);
            current = current.next;
        }
        return head;
    }

    public static <T> void printLinkedList(Node<T> head) {
        Node<T> current = head;
        while (current.next != null) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }
        System.out.println(current.element);
    }

    private static <T> void printLinkedListReversed(Node<T> head) {
        printLinkedListRecursively(head.next);
        System.out.print(head.element);
        System.out.println();
    }

    private static <T> void printLinkedListRecursively(Node<T> head) {
        if (head != null) {
            printLinkedListRecursively(head.next);
            System.out.print(head.element + " -> ");
        }
    }

    public static <T> Node<T> reverseLinkedList(Node<T> head) {
        var current = head.next;
        var previous = head;
        head.next = null;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    static class Node<T> {

        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return String.valueOf(element);
        }
    }

}
