package fundamentals.chapter3.exercises;

import java.util.NoSuchElementException;

/*
    Implementação de uma fila circular.
*/
public class ResizingArrayQueueOfStrings {
    private String[] entries;
    private int size;
    private int maxSize;
    private int first;
    private int last;

    public ResizingArrayQueueOfStrings(int initialCapacity) {
        if (initialCapacity < 1) throw new IllegalArgumentException();

        entries = new String[initialCapacity];
        this.maxSize = initialCapacity;
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    public void enqueue(String value) {
        if (isFull()) {
            resizeQueue(maxSize * 2);
        }

        entries[last] = value;
        last = (last + 1) % maxSize;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("The Stack is empty.");
        }

        String removed = entries[first];
        entries[first] = null;
        first = (first + 1) % maxSize;
        size--;

        if (size > 0 && size == maxSize / 4) {
            resizeQueue(maxSize / 2);
        }

        return removed;
    }

    public void resizeQueue(int newCapacity) {
        String[] newQueue = new String[newCapacity];

        for (int i = 0; i < size; i++) {
            newQueue[i] = entries[(first + i) % maxSize];
        }

        entries = newQueue;
        maxSize = newCapacity;
        first = 0;
        last = size;
    }
}
