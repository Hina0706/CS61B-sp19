public class ArrayDeque<T> {

    private int size = 0;
    private int capacity = 8;
    private int nextFirst = 0;
    private int nextLast = 1;
    private T[] a;

    public ArrayDeque() {
        this(8);
    }
    
    private ArrayDeque(int capacity) {
        a = (T[]) new Object[capacity];
        size = 0;
        this.capacity = capacity;
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
            return capacity + index - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index) {
        if (index > capacity - 1) {
            return index + 1 - capacity;
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
        if (isEmpty()) {
            return null;
        } else {
            T k = a[plusOne(nextFirst)];
            a[minusOne(nextFirst)] = null;
            return k;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T k = a[minusOne(nextLast)];
            a[minusOne(nextLast)] = null;
            return k;
        }
    }

    public T get(int index) {
        int i = plusOne(nextFirst);
        for (int k = 0; k < index; k++) {
            i = plusOne(i);
        }
        return a[i];
    }
}
