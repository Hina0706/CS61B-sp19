package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;

    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    public Iterator<T> iterator(){
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator<T> implements Iterator<T> {
        private int pos;
        public ArrayRingBufferIterator() {
            pos = 0;
        }
        public boolean hasNext() {
            return pos < fillCount();
        }
        public T next() {
            T returnItem = (T) rb[pos];
            pos = addition(pos, 1);
            return returnItem;
        }
    }
    private int addition(int a, int b) {
        return (a + b) % capacity();
    }
    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last.
        if(isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount++;
        last = addition(last, 1);
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */

    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T outp = rb[first];
        rb[first] = null;
        first = addition(first, 1);
        fillCount--;
        return outp;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change.
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        return rb[first];
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.

    @Override
    public int capacity() {
        return rb.length;
    };     // return size of the buffer

    @Override
    public int fillCount() {
        return fillCount;
    };    // return number of items currently in the buffer
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        for (int i = 0; i < fillCount(); i++) {
            if (!dequeue().equals(((ArrayRingBuffer<?>) o).dequeue()) || dequeue().getClass().equals(((ArrayRingBuffer<?>) o).dequeue().getClass())) {
                return false;
            }
        }
        return true;
    };
}
    // TODO: Remove all comments that say TODO when you're done.
