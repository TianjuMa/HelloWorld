package LaiOffer.Implementations;

import java.util.*;

/**
 * The implementation of LRU cache, for generics type.
 */
public class LRUCache<K, V> {
    private static class ListNode<K, V> {
        K key;
        V value;
        ListNode next;
        ListNode prev;

        private ListNode(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }

    private final int CAPACITY;
    Map<K, ListNode<K, V>> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int limit) {// limit is the max capacity of the cache
        CAPACITY = limit;
        map = new HashMap<>();
    }

    public void set(K key, V value) {
        ListNode<K, V> node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else if (map.size() < CAPACITY) {
            node = new ListNode<>(key, value);
            map.put(key, node);
        } else {
            remove(tail);
            node = new ListNode<>(key, value);
        }
        append(node);
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        ListNode<K, V> node = map.get(key);
        remove(node);
        append(node);
        return node.value;
    }

    private void remove(ListNode<K, V> node) {
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = head.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = tail.prev;
        }
        node.prev = null;
        node.next = null;
    }

    private void append(ListNode<K, V> node) {
        map.put(node.key, node);
        if (head != null) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head = tail = node;
        }
    }
}
