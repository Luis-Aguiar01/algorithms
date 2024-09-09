package fundamentals.chapter3.exercises;

import java.util.*;

public class RandomBag<T> implements Iterable<T> {
    private Node first;
    private int size;

    public RandomBag() {}

    private class Node {
        T value;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = first;
        first = newNode;
        size++;
    }

    private class RandomBagIterator implements Iterator<T> {
        List<T> randomBag;
        int currentIndex;

        RandomBagIterator() {
            randomBag = copyBagToList();
            Collections.shuffle(randomBag);
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < randomBag.size();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("The Bag is empty.");
            return randomBag.get(currentIndex++);
        }
    }

    private List<T> copyBagToList() {
        Node current = first;
        List<T> list = new ArrayList<>();

        while (current != null) {
            list.add(current.value);
            current = current.next;
        }

        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }
}
