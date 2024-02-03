package com.bobocode.datastructures.binarySearchTree;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * 👉 Implement a simple Binary Search Tree
 * <p>
 * Create a simple version of a Binary Search Tree implementing the following static methods:
 * <p>
 * createBinarySearchTree – accepts varargs of elements, creates a binary search tree based on them and returns the root node
 * inOrderTraversal – accepts the root node, and an element consumer. Process each node in ascending order using the given consumer
 */
public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        var root = createBinarySearchTree(1, 7, 2, 4, 3, 6, 5);
//        inOrderTraversal(root, System.out::println);
        inOrderTraversalSequential(root, System.out::println);
    }

    private static <T extends Comparable<? super T>> Node<T> createBinarySearchTree(T... elements) {
        var root = new Node<>(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            insertNode(root, elements[i]);
        }
        return root;
    }

    private static <T extends Comparable<? super T>> Node<T> insertNode(Node<T> node, T element) {
        if (node == null) {
            node = new Node<>(element);
            return node;
        }
        if (node.value.compareTo(element) < 0) {
            node.right = insertNode(node.right, element);
        } else if (node.value.compareTo(element) > 0) {
            node.left = insertNode(node.left, element);
        }
        return node;
    }

    static <T extends Comparable<? super T>> void inOrderTraversal(Node<T> node, Consumer<T> elementConsumer) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, elementConsumer);
        elementConsumer.accept(node.value);
        inOrderTraversal(node.right, elementConsumer);
    }

    static <T extends Comparable<? super T>> void inOrderTraversalSequential(Node<T> root, Consumer<T> elementConsumer) {
        Stack<T> stack = new Stack<>();
        stack.push(root.value);
        var current = root.left;
        while (current != null) {
           stack.push(current.value);
           current = current.left;
        }
        stack.forEach(elementConsumer);
    }

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }
}
