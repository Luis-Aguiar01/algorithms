package fundamentals.chapter3;

/*
    Essa implementação de uma Stack resolve o problema
    de trabalhar apenas com um único tipo de dado, no entanto,
    ainda não resolve o problema de a Stack ficar cheia, e não
    poder ser redimensionada.
 */
public class GenericFixedCapacityStack<T> {
    private final T[] entries;
    private int size;

    public GenericFixedCapacityStack(int size) {
        if (size <= 0) throw new IllegalArgumentException();
        entries = (T[]) new Object[size];
    }

    private void push(T v) {
        if (!isFull()) entries[size++] = v;
    }

    private T pop() {
        if (isEmpty()) throw new RuntimeException();

        return entries[--size];
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
}
