package com.lab07_reflection.Animal;

import java.lang.reflect.Field;

/**
 * Create the class Animal. Get all the fields of this class and change all the values using reflection.
 */
public class Main {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Animal animal = new Animal(1, 2, "Kesha");
        System.out.println("Animal before reflection\n" + animal);

        Class<?> cl = animal.getClass();
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);

            if (f.getType().equals(int.class)) {
                f.setInt(animal, (f.getInt(animal)) + 2);
            } else if (f.getType().equals(String.class)) {
                f.set(animal, "Gosha");
            }
        }

        System.out.println("\nAnimal after reflection\n" + animal);
    }
}


