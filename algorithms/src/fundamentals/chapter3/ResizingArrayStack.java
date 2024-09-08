package fundamentals.chapter3;

import java.util.Iterator;

/*
    Essa implementação de Stack resolve o problema do
    redimensionamento quando a Stack está cheia. Ao tentar
    adicionar um novo elemento, caso a Stack esteja cheia,
    ela será redimensionada para duas vezes o seu tamanho atual.
    Além disso, essa classe implementa Iterable, e fornece
    uma Iterator que imprime os elementos da Stack do topo para
    a base.
*/
public class ResizingArrayStack<T> implements Iterable<T>{
    private T[] entries;
    private int size;

    public ResizingArrayStack(int size) {
        if (size <= 0) throw new IllegalArgumentException();
        entries = (T[]) new Object[size];
    }

    private void push(T v) {
        if (isFull()) {
            resize();
        }

        entries[size++] = v;
    }

    private T pop() {
        if (isEmpty()) throw new RuntimeException();

        return entries[--size];
    }

    private void resize() {
        T[] newArray = (T[]) new Object[size * 2];

        for (int i = 0; i < size; i++) {
            newArray[i] = entries[i];
        }

        entries = newArray;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int size() {
        return size;
    }

    private boolean isFull() {
        return size == entries.length;
    }

    private class InverseArrayIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public T next() {
            return entries[--size];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new InverseArrayIterator();
    }
}
