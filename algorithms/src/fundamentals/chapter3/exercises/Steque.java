package fundamentals.chapter3.exercises;

import java.util.NoSuchElementException;

/*
    Steque: Estrutura que é uma junção de uma pilha e fila.
    Permite as operações de pop e push, em uma mesma extremidade,
    e enqueue, que adiciona na extremidade oposta.
*/
public class Steque<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        T value;
        Node next;
    }

    public void push(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = first;
        first = newNode;

        if (last == null) {
            last = newNode;
        }

        size++;
    }

    public T pop() {
        if (size <= 0) throw new NoSuchElementException("The Steque is empty");

        T removedValue = first.value;
        first = first.next;

        if (first == null) {
            last = null;
        }

        size--;

        return removedValue;
    }

    public void enqueue(T value) {
        Node newNode = new Node();
        newNode.value = value;

        if (last == null) {
            first = newNode;
        }
        else {
            last.next = newNode;
        }

        last = newNode;
        size++;
    }

    public int size() {
        return size;
    }
}
