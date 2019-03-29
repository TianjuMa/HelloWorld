package LaiOffer.Implementations;

import java.util.Arrays;

/**
 * A hashTable implementation by map, generic type is provided.
 * supported operations:
 * size()
 * isEmpty()
 * clear()
 * put(K key, V value)
 * get(K key)
 * containsKey(K key)
 * containsValue(V value)
 * remove(K key)
 *
 * @param <K> key
 * @param <V> the value corresponding K
 */
public class MyHashMap<K, V> {
    static class Node<K, V> {
        private final K key;
        private V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void setValue(V value) {
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 10;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;
    private float loadFactor;
    private Node<K, V>[] buckets;

    private MyHashMap(int capacity, float loadFactor) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The input capacity can't be less than 0.");
        }
        buckets = (Node<K, V>[]) new Node[capacity];
        this.loadFactor = loadFactor;
        size = 0;
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        Arrays.fill(buckets, null);
    }

    public V put(K key, V value) {
        int index = getIndex(getHashCode(key));
        Node<K, V> head = buckets[index];
        Node<K, V> temp = head;
        while (temp != null) {
            if (equalsKey(temp.getKey(), key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        buckets[index] = newNode;
        size++;
        if (needRehashing()) {
            rehashing();
        }
        return null;
    }

    public V get(K key) {
        int index = getIndex(getHashCode(key));
        if (index < buckets.length) {
            Node<K, V> temp = buckets[index];
            while (temp != null) {
                if (equalsKey(temp.getKey(), key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return !(get(key) == null);
    }

    public boolean containsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Node<K, V> node : buckets) {
            while (node != null) {
                if (equalsValue(node.getValue(), value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public V remove(K key) {
        int index = getIndex(getHashCode(key));
        Node<K, V> head = buckets[index];
        if (head == null) {
            return null;
        } else if (equalsKey(head.getKey(), key)) {
            buckets[index] = head.next;
            head.next = null;
            size--;
            return head.value;
        }
        Node<K, V> prev = head;
        Node<K, V> cur = prev.next;
        while (cur != null) {
            if (equalsKey(cur.getKey(), key)) {
                prev.next = cur.next;
                cur.next = null;
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    private boolean equalsValue(V value1, V value2) {
        return value1 == null && value2 == null || !(value1 == null || value2 == null) && value1.equals(value2);
    }

    private boolean equalsKey(K key1, K key2) {
        return key1 == null && key2 == null || !(key1 == null || key2 == null) && key1.equals(key2);
    }

    private int getIndex(int hashCode) {
        return hashCode % buckets.length;
    }

    private int getHashCode(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0x7FFFFFFF;
    }

    private boolean needRehashing() {
        return (float) size >= loadFactor * buckets.length;
    }

    private void rehashing() {
        buckets = Arrays.copyOf(buckets, 2 * buckets.length);
    }
}