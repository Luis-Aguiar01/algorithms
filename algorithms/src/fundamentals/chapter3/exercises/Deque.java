package fundamentals.chapter3.exercises;

import java.util.NoSuchElementException;

public class Deque<T>{
    private Node first;
    private Node last;
    private int size;

    public Deque() {}

    private class Node {
        T value;
        Node next;
        Node prev;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void pushLeft(T value) {
        Node newNode = createNode(value);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }

        size++;
    }

    public void pushRight(T value) {
        Node newNode = createNode(value);

        if (last == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    public T popLeft() {
        if (isEmpty()) throw new NoSuchElementException("The Deque is empty.");

        T removedValue = first.value;
        first = first.next;

        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }

        size--;

        return removedValue;
    }

    public T popRight() {
        if (isEmpty()) throw new NoSuchElementException("The Deque is empty.");

        T removedValue = last.value;
        last = last.prev;

        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }

        size--;

        return removedValue;
    }

    private Node createNode(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        newNode.prev = null;

        return newNode;
    }
}
