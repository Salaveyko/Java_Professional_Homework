package com.lab10_cloning.ExtendedClone;

/**
 * Create the classes Animal and Eagle. Eagle should extend the Animal.
 * Clone the object.
 */
public class Main {
    public static void main(String[] args) {
        Eagle eagle = new Eagle(5.5, 10);
        Eagle eagleClone = eagle.clone();

        System.out.println("Eagle\n" + eagle);
        System.out.println("\nEagle clone\n" + eagleClone);
    }
}
