package com.bobocode.datastructures;

import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * ONLINE TRAINING 6 | TASK 0
 * 👉 Implement a simple Binary Search Tree
 * <p>
 * Create a simple version of a Binary Search Tree implementing the following static methods:
 * createBinarySearchTree – accepts varargs of elements, creates a binary search tree based on them and returns the root node
 * inOrderTraversal – accepts the root node, and an element consumer. Process each node in ascending order using the given consumer
 * Prep a simple demo showing those methods work
 * Post  screenshots of your code in the Thread 👇
 */
public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        var stringJoiner = new StringJoiner(", ");
        Node<Integer> root = createBinarySearchTree(5, 7, 4, 3, 6, 8, 9, 1, 5, 2);
        inOrderTraversal(root, value -> stringJoiner.add(String.valueOf(value)));

        System.out.println(stringJoiner);
    }

    private static <T extends Comparable<? super T>> Node<T> createBinarySearchTree(T... elements) {
        var root = new Node<>(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            insertElement(root, elements[i]);
        }
        return root;
    }

    private static <T extends Comparable<? super T>> Node<T> insertElement(Node<T> node, T element) {
        if (node == null) {
            node = new Node<>(element);
            return node;
        }
        if (element.compareTo(node.value) > 0) {
            node.right = insertElement(node.right, element);
        } else if (element.compareTo(node.value) < 0){
            node.left = insertElement(node.left, element);
        }
        return node;
    }

    private static <T extends Comparable<? super T>> void inOrderTraversal(Node<T> root, Consumer<T> elementConsumer) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, elementConsumer);
        elementConsumer.accept(root.value);
        inOrderTraversal(root.right, elementConsumer);
    }

    private static class Node<T> {
        T value;
        Node<T> right;
        Node<T> left;

        public Node(T element) {
            this.value = element;
        }
    }

}
