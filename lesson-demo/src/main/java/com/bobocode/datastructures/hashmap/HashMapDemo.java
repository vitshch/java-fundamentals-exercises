package com.bobocode.datastructures.hashmap;


import java.util.Objects;

/**
 * 👉 Build a simple version of a HashMap
 * <p>
 * Create a custom HashMap with the following API:
 * <p>
 * put(key, value) – accepts a key, and a value, stores the value by the given key and returns the old value (or null if there is no old value)
 * get(key) – accepts a key, returns the corresponding value by the given key (or null if such key does not exist)
 * <p>
 * Optimize your HashMap: Implement the table resize logic that automatically doubles the table size when number of elements equals the table capacity
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap(3);

        for (int i = 0; i < 20; i++) {
            map.put(i, String.format("Demo %d", i));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(map.get(i));
        }
    }

}

class HashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 8;

    private int capacity;
    private Node<K, V>[] elements;
    private int size;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.elements = new Node[capacity];
    }

    public V put(K key, V value) {
        size++;
        ensureCapacity();
        int index = calculateIndex(key);
        var node = elements[index];
        if (node != null) {
            var current = node;
            while (current != null) {
                if (Objects.equals(current.key, key)) {
                    var old = current.value;
                    current.value = value;
                    return old;
                }
                current = current.next;
            }
            current.next = new Node<>(key, value);
        } else {
            elements[index] = new Node<>(key, value);
        }
        return null;
    }

    public V get(K key) {
        int index = calculateIndex(key);
        Node<K, V> element = elements[index];

        while (element != null) {
            if (Objects.equals(element.key, key)) {
                return element.value;
            }
            element = element.next;
        }
        return null;
    }

    private int calculateIndex(K key) {
        return key.hashCode() % capacity;
    }

    private void ensureCapacity() {
        if (size / capacity >= 0.75) {
            System.out.println("The capacity of HashMap small, increasing capacity");
            capacity *= 2;
            var oldStorage = this.elements;
            this.elements = new Node[capacity];
            for (var node : oldStorage) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}