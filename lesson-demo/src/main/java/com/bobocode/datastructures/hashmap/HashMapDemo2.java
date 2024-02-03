package com.bobocode.datastructures.hashmap;

/**
 * 👉 Build a simple version of a HashMap
 * <p>
 * Create a custom HashMap with the following API:
 * put(key, value) – accepts a key, and a value, stores the value by the given key and returns the old value (or null if there is no old value)
 * get(key) – accepts a key, returns the corresponding value by the given key (or null if such key does not exist)
 * Prep a demo showing that it works
 * Post  screenshots of your code in the Thread 👇
 */

public class HashMapDemo2 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(2);
        map.put(1, "Hello");
        map.put(2, "World");
        map.put(3, "Good");
        map.put(4, "Morning");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
    }

    static class HashMap<K, V> {

        private static final int DEFAULT_CAPACITY = 8;

        int capacity;
        int size;

        Node<K, V>[] nodes;

        public HashMap() {
            this.capacity = DEFAULT_CAPACITY;
            this.nodes = new Node[capacity];
        }

        public HashMap(int capacity) {
            this.capacity = capacity;
            this.nodes = new Node[capacity];
        }

        V put(K key, V value) {
            ensureCapacity();
            int index = getIndex(key);
            var newNode = new Node<>(key, value);
            Node<K, V> node = nodes[index];
            if (node == null) {
                nodes[index] = newNode;
                size++;
            } else {
                while (node.next != null) {
                    if (node.key.equals(key)) {
                        var old = node.value;
                        node.value = value;
                        return old;
                    }
                    node = node.next;
                }
                node.next = newNode;
                size++;
            }
            return null;
        }

        V get(K key) {
            int index = getIndex(key);
            var node = nodes[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }

        private int getIndex(K key) {
            return (key.hashCode() + 31) % capacity;
        }

        private void ensureCapacity() {
            if (size / capacity > 0.8) {
                var oldNodes = nodes;
                capacity *= 2;
                nodes = new Node[capacity];

                for (Node<K, V> oldNode : oldNodes) {
                    var node = oldNode;
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

            public Node(K key) {
                this.key = key;
            }

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

    }

}
