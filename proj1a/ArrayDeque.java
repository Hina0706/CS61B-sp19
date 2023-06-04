public class ArrayDeque<T> {

    private int size = 0;
    private int capacity = 8;
    private int nextFirst = 0;
    private int nextLast = 1;
    private T[] a;
    private double usageFactor = 0.25;
    private double usageRatio = 0.0;

    public ArrayDeque() {
        this(8);
    }

    private ArrayDeque(int capacity) {
        a = (T[]) new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    private void resize(int newCapacity) {
        T[] k = (T[]) new Object[newCapacity];
        int m = nextFirst;
        for (int i = 0; i < size; i++) {
            m = plusOne(m);
            k[i] = a[m];
        }
        a = k;
        nextFirst = newCapacity - 1;
        nextLast = size;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean needShrink() {
        if (usageRatio < usageFactor && capacity > 8) {
            return true;
        }
        return false;
    }

    // deep copy
    // public ArrayDeque(ArrayDeque other) {
    //     this();
    //     for (int k = 0; k < other.size; k++) {
    //         addLast((T) other.get(k));
    //     }
    // }

    private int minusOne(int index) {
        if (index - 1 < 0) {
            return capacity + index - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index) {
        if (index >= capacity - 1) {
            return index + 1 - capacity;
        } else {
            return index + 1;
        }
    }

    // add and remove must take constant time, except during resizing operations.
    public void addFirst(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }
        a[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }
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
            nextFirst = plusOne(nextFirst);
            T k = a[nextFirst];
            a[nextFirst] = null;
            size--;
            if (needShrink()) {
                resize(capacity / 2);
            }
            return k;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            nextLast = minusOne(nextLast);
            T k = a[nextLast];
            a[nextLast] = null;
            size--;
            if (needShrink()) {
                resize(capacity / 2);
            }
            return k;
        }
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int i = plusOne(nextFirst);
        for (int k = 0; k < index; k++) {
            i = plusOne(i);
        }
        return a[i];
    }
}
