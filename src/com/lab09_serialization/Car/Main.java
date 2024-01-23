package com.lab09_serialization.Car;

import com.lab09_serialization.builder.FileBuilder;

import java.io.*;

/**
 * Create a Car class. Serialize and deserialize it using Externalize.
 */
public class Main {

    public static void main(String[] args) {
        File carFile = FileBuilder.build("car.cl");
        File animalFile = FileBuilder.build("animal.cl");

        Car car = new Car("Audi", 300);
        System.out.println(car);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(carFile))) {
            out.writeObject(car);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Car inCar = new Car();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(carFile))) {
            inCar = (Car) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(inCar);
    }
}
