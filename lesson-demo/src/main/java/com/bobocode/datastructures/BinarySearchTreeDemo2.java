package com.bobocode.datastructures;

import java.util.function.Consumer;

/**
 * **Implement a simple Binary Search Tree**
 * <p>
 * - **Create** a simple version of a Binary Search Tree implementing the following static methods:
 * - `createBinarySearchTree` – accepts varargs of elements, creates a binary search tree based on them and returns the root node
 * - `inOrderTraversal` – accepts the root node, and an element consumer. Process each node in ascending order using the given consumer
 * - **Prep** a simple demo showing those methods work
 * - *Post ** screenshots of your code in the Thread 👇
 */
public class BinarySearchTreeDemo2 {

    public static void main(String[] args) {
        Node<Integer> root = createBinarySearchTree(5, 6, 3, 2, 4, 1, 7);
        inOrderTraversal(root, System.out::println);
    }

    private static <T extends Comparable<? super T>> Node<T> createBinarySearchTree(T... elements) {
        Node<T> root = new Node<>(elements[0]);
        var current = root;
        for (int i = 1; i < elements.length; i++) {
            insertElement(current, elements[i]);
        }
        return root;
    }

    private static <T extends Comparable<? super T>> Node<T> insertElement(Node<T> node, T element) {
        if (node == null) {
            node = new Node<>(element);
            return node;
        }
        if (node.value.compareTo(element) < 0) {
            node.right = insertElement(node.right, element);
        } else if (node.value.compareTo(element) > 0) {
            node.left = insertElement(node.left, element);
        }
        return node;
    }

    private static void inOrderTraversal(Node<?> root, Consumer<? super Object> elementConsumer) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, elementConsumer);
        elementConsumer.accept(root.value);
        inOrderTraversal(root.right, elementConsumer);
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
