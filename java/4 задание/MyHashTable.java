package ru.vsuet.hashmap;

public class MyHashTable {
    private static final int dcapacity = 16;
    private static final float kefzagruzki = 0.75f;
    private int capacity;
    private int size;
    private Node[] table;

    public MyHashTable(int capacity) {
        this.capacity = dcapacity;
        this.size = 0;
        this.table = new Node[capacity];
    }
    public MyHashTable() {
        this(16);
    }
    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = 31 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    private void resize() {
        capacity *= 2;
        Node[] newTable = new Node[capacity];

        for (Node node : table) {
            Node current = node;
            while (current != null) {
                int index = hash(current.key) % capacity;
                Node newNode = new Node(current.key, current.value);

                if (newTable[index] == null) {
                    newTable[index] = newNode;
                } else {
                    Node temp = newTable[index];
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newNode;
                }

                current = current.next;
            }
        }
        table = newTable;
    }

    public void put(String key, String value) {
        if (size >= capacity * kefzagruzki) {
            resize();
        }

        int index = hash(key) % capacity;
        Node newNode = new Node(key, value);
        Node current = table[index];

        if (current == null) {
            table[index] = newNode;
        } else {
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void remove(String key) {
        int index = hash(key) % capacity;
        Node current = table[index];

        if (current != null && current.key.equals(key)) {
            table[index] = current.next;
            size--;
            return;
        }

        while (current != null && current.next != null) {
            if (current.next.key.equals(key)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Некорректный ключ");
    }

    public String get(String key) {
        int index = hash(key) % capacity;
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Некорректный ключ");
    }
    public String toString() {
        StringBuilder result = new StringBuilder("Hash Table\n");
        String[] keys = keys();

        for (String key : keys) {
            result.append(key).append(" | ").append(get(key)).append("\n");
        }
        return result.toString();
    }

    public String[] keys() {
        String[] keys = new String[size];
        int index = 0;
        for (Node node : table) {
            Node current = node;
            for (int i = 0; current != null; current = current.next) {
                keys[index] = current.key;
                index++;
            }
        }
        return keys;
    }

    private static class Node {
        private final String key;
        private String value;
        private Node next;
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
