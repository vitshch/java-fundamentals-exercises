package com.bobocode.datastructures;

public class LinkedListDemo {

    public static void main(String[] args) {
        System.out.println("Create LinkedList:");
        var linkedList = createLinkedList(1, 2, 3, 4, 5, 6);
        printLinkedList(linkedList);

        System.out.println("Add on index 0(head):");
        linkedList = addToLinkedList(linkedList, 0, 222);
        printLinkedList(linkedList);

        System.out.println("Add on index 3:");
        linkedList = addToLinkedList(linkedList, 3, 123);
        printLinkedList(linkedList);

        System.out.println("Add to index 7(tail):");
        linkedList = addToLinkedList(linkedList, 7, 999);
        printLinkedList(linkedList);

    }

    private static <T> Node<T> createLinkedList(T... elements) {
        var head = new Node<>(elements[0]);
        var current = head;
        for (int i = 1; i < elements.length; i++) {
            current.next = new Node<>(elements[i]);
            current = current.next;
        }
        return head;
    }

    private static <T> Node<T> addToLinkedList(Node<T> head, int index, T element) {
        var newNode = new Node<>(element);
        var current = head;
        int i = 0;
        if (index == 0) {
            newNode.next = head.next;
            return newNode;
        } else {
            while (i < index - 1) {
                current = current.next;
                i++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return head;
    }

    private static void printLinkedList(Node<?> node) {
        if (node.next != null) {
            System.out.print(node.element + " -> ");
            printLinkedList(node.next);
        } else {
            System.out.println(node.element);
        }
    }

    private static void printLinkedListRecursive(Node<?> node) {

    }

    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
