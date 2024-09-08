package fundamentals.chapter3;

/*
    Representa, de forma simplificada, uma Stack.
    No entanto, essa implementação possui uma série de problemas,
    como: A Stack não é genérica, ou seja, não pode trabalhar com
    outros tipos de dados. A Stack não é dinâmica, quando a sua
    capacidade inicial for alcançada ela não pode ser redimensionada.
*/

public class FixedCapacityStack {
    private final String[] entries;
    private int size;

    public FixedCapacityStack(int size) {
        if (size <= 0) throw new IllegalArgumentException();
        entries = new String[size];
    }

    private void push(String v) {
        if (!isFull()) entries[size++] = v;
    }

    private String pop() {
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
