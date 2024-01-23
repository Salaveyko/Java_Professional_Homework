package com.lab09_serialization.Animal;

import com.lab09_serialization.builder.FileBuilder;

import java.io.*;

/**
 * Create the Animal class. Serialize and deserialize this object.
 */
public class Main {
    public static void main(String[] args) {
        File animalFile = FileBuilder.build("animal.cl");

        Animal animal = new Animal("Bobik", 5, "Dvor terrier");
        System.out.println(animal);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(animalFile))) {
            out.writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Animal inAnimal = new Animal();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(animalFile))) {
            inAnimal = (Animal) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(inAnimal);
    }
}
