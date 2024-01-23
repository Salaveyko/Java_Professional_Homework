package com.lab01_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Tasks:
 * 1. Create a List end fill it in.
 * 2. Print the data contained in the List to the console using an Iterator. I decided to
 * override the toString() method in the List anonymously and use an Iterator there.
 * Additional task:
 * Implement logic in the compareTo() method that compares an object by: speed, price,
 * weight, and then breed.
 */
public class Main {
    public static void main(String[] args) {
        List<Animal> zoo = new ArrayList<>() {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder("\tAnimals:\n");
                Iterator<Animal> i = this.iterator();
                while (i.hasNext()) {
                    sb.append(i.next()).append("\n");
                }
                return sb.toString();
            }
        };

        zoo.add(new Animal("Bengal tiger", 60, 40, 250000));
        zoo.add(new Animal("Labrador", 15, 25, 5000));
        zoo.add(new Animal("King Penguin", 11, 8, 50000));
        zoo.add(new Animal("Goat", 15, 25, 5000));
        zoo.add(new Animal("Bobcat", 10, 25, 5000));

        System.out.println(zoo);
        Collections.sort(zoo);
        System.out.println(zoo);


    }
}
