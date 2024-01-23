package com.lab03_collections.SimpleHashTable;

/**
 * Just a simple implementation of a HashTable.
 */
public class SimpleHashTableMain {
    public static void main(String[] args) {
        SimpleHashTable<String, String> table = new SimpleHashTable<>();
        
        System.out.println("is empty " + table.isEmpty());
        
        table.put("Alex", "Solovyov");
        table.put("Alex", "Solovey");
        table.put("Tania", "Solovey");
        table.put("Rita", "Gorobets");
        table.put("Vania", "Vintik");

        System.out.println(table);
        System.out.println("size " + table.size());
        System.out.println("is empty " + table.isEmpty());
        System.out.println("remove " + table.remove("Alex"));
        System.out.println(table);
        table.put("Alex", "Solovyov");
        System.out.println(table);
        System.out.println("size " + table.size());
        table.clear();
        System.out.println("after clear size " + table.size());
    }
}
