public class Humans implements List {
    private Node head;
    private int count;

    public void Humans() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public void addToBegin(Human element) {
        Node newNode = new Node(element);

        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        count++;
    }

    private static class Node {
        private Human value;
        private Node next;

        Node(Human value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public Iterator iterator() {
        return new HumansIterator();
    }

    private class HumansIterator implements Iterator {

        private Node currentNode;

        HumansIterator() {
            currentNode = head;
        }

        @Override
        public String nextName() {
            Human element = currentNode.value;
            return element.getName();
        }

        @Override
        public int nextAge() {
            Human element = currentNode.value;
            currentNode = currentNode.next;
            return element.getAge();
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }


}