package fundamentals.chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {
    private Node first;
    private int size;

    private class Node {
        T value;
        Node next;
    }

    public void add(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private class ListIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The bag is empty.");
            }
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
