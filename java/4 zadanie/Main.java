package ru.vsuet.hashmap;


public class Main {
    public static void main(String[] args) {

        MyHashTable hashTable = new MyHashTable(16);

        hashTable.put("один", "1");
        hashTable.put("два", "2");
        hashTable.put("три", "3");
        hashTable.put("четыре", "4");
        hashTable.put("пять", "5");

        hashTable.toString();

        try {
            String value = hashTable.get("три");
            System.out.println("Значение для ключа 'три': " + value);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            hashTable.remove("два");
            System.out.println("Удален ключ 'два'");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        hashTable.toString();
    }
}
