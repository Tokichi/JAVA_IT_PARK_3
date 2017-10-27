package com.company;

public class StringLinkedList implements List{
    private Node head;
    private int count;


    public void addToBegin(String element) {
        Node newNode = new Node(element);

        if (head != null) {
            newNode.next = head;
        }

        head = newNode;
        count++;

    }
    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {

        private Node currentNode;

        LinkedListIterator() {
            currentNode = head;
        }

        public String next() {
            String element = currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        public boolean hasNext() {
            return currentNode != null;
        }
    }

    private static class Node {
        private String value;
        private Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

}