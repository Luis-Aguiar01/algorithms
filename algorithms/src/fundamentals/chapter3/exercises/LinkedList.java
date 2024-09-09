package fundamentals.chapter3.exercises;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node first;
    private int size;

    private class Node {
        T value;
        Node next;
    }

    public void addAtStart(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public T removeAtStart() {
        T removedValue = first.value;
        first = first.next;
        size--;
        return removedValue;
    }

    // EX 1.3.19
    public T removeLastNode() {
        if (isEmpty()) throw new NoSuchElementException("The list is empty.");

        Node current = first;
        Node prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        T removedValue = current.value;

        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }

        size--;

        return removedValue;
    }

    // EX 1.3.20
    public T delete(int k) {
        if (k <= 0 || k > size) throw new NoSuchElementException();

        Node current = first;
        Node prev = null;
        int count = 1;

        while (count != k) {
            prev = current;
            current = current.next;
            count++;
        }

        T removedValue = current.value;

        if (first == current && size == 1) {
            first = null;
        } else if (first == current) {
            first = first.next;
        } else if (current.next == null) {
            prev.next = null;
        } else {
            prev.next = current.next;
        }

        size--;

        return removedValue;
    }

    // EX 1.3.21
    public boolean find(LinkedList<T> list, String key) {
        if (list.size == 0) return false;

        Node current = list.first;

        while (current != null) {
            if (String.valueOf(current.value).equalsIgnoreCase(key)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Ex 1.3.24
    public void removeAfter(Node node) {
        if (node != null && node.next != null) {
            node.next = node.next.next;
            size--;
        }
    }

    // EX 1.3.25
    public void insertAfter(Node insertAfter, Node insert) {
        if (insertAfter != null && insert != null) {
            insert.next = insertAfter.next;
            insertAfter.next = insert;
            size++;
        }
    }

    // EX 1.3.30
    public Node reverse(Node node) {
        Node first = node;
        Node reverse = null;

        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }

        return reverse;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class ListIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("");

            T value = current.value;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
}
