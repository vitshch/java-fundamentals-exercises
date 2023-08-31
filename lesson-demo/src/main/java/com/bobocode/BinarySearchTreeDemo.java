package com.bobocode;

import java.util.function.Consumer;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        var treeRoot = createBinarySearchTree(6, 4, 5, 2, 3, 7, 1);
        inOrderTraversal(treeRoot, System.out::println); // should print 1,2,3,4,5,6,7
    }

    /**
     * Creates a binary search tree based on the given elements and returns the root node.
     *
     * @param elements
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> Node<T> createBinarySearchTree(T... elements) {
        Node<T> head = new Node<>(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            insert(head, elements[i]);
        }
        return head;
    }

    private static <T extends Comparable<? super T>> Node<T> insert(Node<T> node, T element) {
        if (node.element.compareTo(element) < 0) {
            if (node.left == null) {
                node.left = new Node<>(element);
            } else {
                insert(node.left, element);
            }
        } else if (node.element.compareTo(element) > 0) {
            if (node.right == null) {
                node.right = new Node<>(element);
            } else {
                insert(node.right, element);
            }
        }
        return node;
    }


    public static <T> void inOrderTraversal(Node<T> root, Consumer<? super T> consumer) {
        if (root != null) {
            inOrderTraversal(root.left, consumer);
            consumer.accept(root.element);
            inOrderTraversal(root.right, consumer);
        }
    }


    static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.element = element;
        }
    }

}
