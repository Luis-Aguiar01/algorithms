package fundamentals.chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private Node top;
    private int size;

    public Stack() {}

    private class Node {
        T value;
        Node next;
    }

    public void push(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The Stack is empty.");

        }
        Node removed = top;
        top = top.next;
        size--;

        return removed.value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The Stack is empty.");
        }

        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    private class StackIterator implements Iterator<T> {
        Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("The Stack is empty.");
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
