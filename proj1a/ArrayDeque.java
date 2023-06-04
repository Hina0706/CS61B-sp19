public class ArrayDeque<T> {

    private int size;
    private int length;
    private int nextFirst;
    private int nextLast;
    private T[] a;

    public ArrayDeque() {
        a = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 7;
        length = 8;
    }

    // deep copy
    public ArrayDeque(ArrayDeque other) {
        this();
        for (int k = 0; k < other.size; k++) {
            addLast((T) other.get(k));
        }
    }

    private int minusOne(int index) {
        if (index - 1 < 0) {
            return length + index - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index) {
        if (index > length - 1) {
            return index + 1 - length;
        } else {
            return index + 1;
        }
    }

    // add and remove must take constant time, except during resizing operations.
    public void addFirst(T item) {
        a[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item) {
        a[nextLast] = item;
        size++;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = plusOne(nextFirst);
        for (int k = 0; k < size; k++) {
            System.out.print(a[i]);
            i = plusOne(i);
        }
        System.out.println();
    }

    // add and remove must take constant time, except during resizing operations.
    public T removeFirst() {
        T k = a[plusOne(nextFirst)];
        a[minusOne(nextFirst)] = null;
        return k;
    }

    public T removeLast() {
        T k = a[minusOne(nextLast)];
        a[minusOne(nextLast)] = null;
        return k;
    }

    public T get(int index) {
        int i = plusOne(nextFirst);
        for (int k = 0; k < index; k++) {
            i = plusOne(i);
        }
        return a[i];
    }
}
