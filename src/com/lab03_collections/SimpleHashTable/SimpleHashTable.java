package com.lab03_collections.SimpleHashTable;

import java.util.*;

public class SimpleHashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private Entry<K, V>[] table;

    public SimpleHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleHashTable(int capacity) {
        if (capacity <= 0) {
            this.capacity = DEFAULT_CAPACITY;
        } else {
            this.capacity = capacity;
        }
        table = new Entry[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.next;
        }

        return null;
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                    return;
                }
                current = current.next;
            }
            current.next = new Entry<>(key, value);
        }
        size++;
    }

    public Entry<K, V> remove(K key) {
        int index = getIndex(key);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                current.next = null;
                size--;
                return current;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nTable:\n");
        for (var e : table) {
            Entry<K, V> current = e;
            while (current != null){
                sb.append(current).append("\n");
                current = current.next;
            }
        }
        return sb.toString();
    }

    private int getIndex(K key) {
        return key.hashCode() % capacity;
    }

    private class Entry<K, V> {

        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V v = this.value;
            this.value = value;
            return v;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }
    }

}
