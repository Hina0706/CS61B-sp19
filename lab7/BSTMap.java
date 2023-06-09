import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private int size;
    private Node root;

    private class Node {
        public V value;
        public K key;
        public Node left, right;
        public Node(K x, V y) {
            key = x;
            value = y;
            left = null;
            right = null;
        }
    }

    public BSTMap() {}

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        size = 0;
        root = null;
    };

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return !(get(key) == null);
    };

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return get(root, key);
    };
    private V get(Node node, K key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        if (node == null) {return null;}
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return node.value;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    };

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        root = put(root, key, value);
        size++;
    };
    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value);
        } else {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) {x.right = put(x.right, key, value);}
            if (cmp < 0) {x.left = put(x.left, key, value);}
            else {x.value = value;}
            return x;
        }
    }


    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("");
    };

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("");
    };

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("");
    };

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("");
    }

    /* prints out your BSTMap in order of increasing Key */
    public void printInOrder() {
//        if (root.left)
    }
}
