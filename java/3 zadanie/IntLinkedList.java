package ru.vsuet.list;

import java.util.function.Predicate;

public class IntLinkedList implements IntList {
    private Node head;
    private int size;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public int get(int idx) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + size);
        }

        Node current = head;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void add(int value) {
        if (value < 0) {
            throw new IndexOutOfBoundsException("List does not accept negative values.");
        }

        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int idx, int value) {
        if (idx > size || idx < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + size);
        }
        if (value < 0) {
            throw new IndexOutOfBoundsException("List does not accept negative values.");
        }
        if (idx == 0) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(int idx) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + size);
        }
        if (idx == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public void remove(Predicate<Integer> condition) {
        Node current = head;
        Node previous = null;
        int count = 0;
        while (current != null && count<2) {
            if (condition.test(current.value)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                count++;
            } else {
                previous = current;
            }
            current = current.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public void printList() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        System.out.println(sb.toString());
    }
}
