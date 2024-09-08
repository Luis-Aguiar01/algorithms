package fundamentals.chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    public Queue() {}

    private class Node {
        T value;
        Node next;
    }

    public void enqueue(T value) {
        Node newNode = new Node();
        newNode.value = value;

        if (isEmpty()) {
            first = newNode;
        }
        else {
            last.next = newNode;
        }

        last = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow.");
        }

        T value = first.value;

        if (first == last) {
            first = null;
            last = null;
        }
        else {
            first = first.next;
        }

        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow.");
        }

        return first.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private class QueueIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The queue is empty.");
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
}
