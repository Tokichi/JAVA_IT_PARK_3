package com.company;

import java.util.Iterator;

public class HashSet<V> {
    private int count = 0;

    private static class Node<T, E> {
        private T key;
        private E value;
        private Node<T, E> next;
    }

    private Node<V, V> buckets[];

    public HashSet() {
        this.buckets = new Node[16];
    }

    public void put(V value) {
        int hash = value.hashCode();
        int index = hash & (buckets.length - 1);

        if (buckets[index] == null) {
            Node<V, V> newNode = new Node<>();
            newNode.key = value;
            newNode.value = value;
            buckets[index] = newNode;
            count++;
        } else {
            Node<V, V> current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(value)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(value)) {
                current.value = value;
                return;
            }
            Node<V, V> newNode = new Node<>();
            newNode.key = value;
            newNode.value = value;
            current.next = newNode;
            count++;
        }
    }

    public Iterator iterator() {
        return new HashMapIterator();
    }

    public class HashMapIterator implements Iterator {

        private int current = 0;
        private int currentindex = 0;
        private Node<V, V> currentNode;
        private Node<V, V> tempNode;

        public boolean hasNext() {
            return current < count;
        }

        public V next() {
            while (current < count) {
                while (buckets[currentindex] == null) {
                    currentindex++;
                }
                if(currentNode == tempNode) {
                    currentNode = buckets[currentindex];
                }

                while (currentNode != null) {
                    tempNode = currentNode;
                    if (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }else {
                        currentindex++;
                    }
                    current++;
                    return tempNode.value;
                }
            }
            current++;
            return tempNode.value;
        }
    }
}
