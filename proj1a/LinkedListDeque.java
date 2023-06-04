import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> extends LinkedList<T> implements Deque<T>{

    private int size;
    private IntNode sentinel;

    private class IntNode {
        T item;
        IntNode prev;
        IntNode next;

        public IntNode() {
            item = null;
            prev = null;
            next = null;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    // deep copy
    public LinkedListDeque(LinkedListDeque other) {
        this();
        for (int i = 0; i < other.size; i++){
            addLast((T) other.get(i));
        }
    }

    // add and remove operations must not involve any looping or recursion
    // A single such operation must take “constant time”,
    // i.e. execution time should not depend on the size of the deque.
    @Override
    public void addFirst(T item) {
        IntNode p = sentinel.next;
        IntNode newNode = new IntNode();
        newNode.item = item;
        newNode.prev = sentinel;
        newNode.next = p;
        sentinel.next = newNode;
        p.prev = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        IntNode p = sentinel.prev;
        IntNode newNode = new IntNode();
        newNode.item = item;
        newNode.prev = p;
        newNode.next = sentinel;
        p.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    // size must take constant time.
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
        }
        System.out.println();
    }

    // add and remove operations must not involve any looping or recursion
    // A single such operation must take “constant time”,
    // i.e. execution time should not depend on the size of the deque.
    // Removes and returns the item at the front of the deque. If no such item
    // exists, returns null.
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            IntNode p = sentinel.next;
            sentinel.next = p.next;
            p.next.prev = sentinel;
            size--;
            return p.item;
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            IntNode p = sentinel.prev;
            sentinel.prev = p.prev;
            p.prev.next = sentinel;
            size--;
            return p.item;
        }
    }

    @Override
    // get must use iteration, not recursion.
    public T get(int index) {
        IntNode p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    private T getRcrs(IntNode p, int index) {
        if (index == 0) {
            return p.item;
        } else {
            return getRcrs(p.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        return getRcrs(sentinel.next, index);
    }

}
