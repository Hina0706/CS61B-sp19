public class ArrayDeque<T> {

    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] a;

    public ArrayDeque() {
      a = (T[]) new Object[8];
      size = 0;
      nextFirst = 0;
      nextLast = 7;
    }

    // deep copy
    public ArrayDeque(ArrayDeque other) {

    }

    private int minusOne(int index) {
      return 1;
    }

    private int plusOne(int index) {
      return 1;
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
      for (int i = 0; i < size; i++) {
        System.out.print(a[i]);
      }
      System.out.println("");
    }

    // add and remove must take constant time, except during resizing operations.
    public T removeFirst() {
      
    }

    public T removeLast() {

    }

    public T get(int index) {
        return 
    }
}
