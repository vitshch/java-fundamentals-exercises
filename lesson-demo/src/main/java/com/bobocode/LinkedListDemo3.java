package com.bobocode;


import java.util.List;

//Create a simple version of Linked List implementing the following static methods:
//        createLinkedList – accepts varargs of elements, creates a linked list based on them and returns the head node
//        addToLinkedList – accepts the head of the list, an index, and a new element and adds a new node of the given element by the given index
//        printLinkedList – accepts the head node and prints list in the following format 1 -> 2 -> 3 -> 4 -> 5
//        Prep a simple demo showing those methods work
//        Post screenshots of your code in the Thread 👇
public class LinkedListDemo3 {

    public static void main(String[] args) {
        Node<Integer> linkedList = createLinkedList(2, 4, 5, 6, 7);
        printLinkedList(linkedList);
        addToLinkedList(linkedList, 2, 10);
    }

    private static <T> Node<T> createLinkedList(int... elements) {
        var head = new Node(elements[0]);
        var current = head;
        for (int i = 1; i < elements.length; i++) {
            current.next = new Node<>(elements[i]);
            current = current.next;
        }
        return head;
    }

    // todo
    private static <T> void addToLinkedList(Node<T> head, int i, T element) {
        int index = 0;
        var current = head;
        var newNode = new Node<>(element);
    }

    // 2 -> 4 -> 5 -> 6 -> 7
    private static <T> void printLinkedList(Node<T> node) {
        if (node.next != null) {
            System.out.print(node.element + " -> ");
            printLinkedList(node.next);
        } else {
            System.out.print(node.element);
        }
    }

    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
}
